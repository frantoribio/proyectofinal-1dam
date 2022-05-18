package es.dam.mcdam.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import es.dam.mcdam.managers.DataBaseManager;
import es.dam.mcdam.models.CodigoDescuento;
import es.dam.mcdam.models.PersonaRegistrada;
import es.dam.mcdam.models.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class ProductoRepository implements IProductoRepository {
    private static ProductoRepository instance;
    private final ObservableList<Producto> repository = FXCollections.observableArrayList();
    //TODO: Añadir backup
    //private final Storage storage = Storage.getInstance();
    //TODO usar Logger
    DataBaseManager db = DataBaseManager.getInstance();

    private ProductoRepository() {}

    public static ProductoRepository getInstance() {
        if (instance == null) {
            instance = new ProductoRepository();
        }
        return instance;
    }

    @Override
    public Optional<ObservableList<Producto>> findAll() throws SQLException {
        String sql = "SELECT * FROM producto";
        db.open();
        ResultSet rs = db.select(sql).orElseThrow(() -> new SQLException("Error al obtener todos los productos"));
        repository.clear();
        while (rs.next()) {
            repository.add(
                    new Producto(
                            rs.getString("uuuid"),
                            rs.getString("nombre"),
                            rs.getFloat("precio"),
                            rs.getString("imagen"),
                            rs.getString("descripcion"),
                            rs.getBoolean("disponible"),
                            (CodigoDescuento) rs.getObject("codigoDescuento")
                    )
            );
        }
        db.close();
        if (repository.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(repository);
    }

    @Override
    public Optional<Producto> findById(String uuid) throws SQLException {
        String sql = "SELECT * FROM producto WHERE uuid = ?";
        db.open();
        var rs = db.select(sql, uuid).orElseThrow(() -> new SQLException("Error al obtener el producto con uuid: " + uuid));
        while (rs.next()) {
            var producto = new Producto(
                    rs.getString("uuuid"),
                    rs.getString("nombre"),
                    rs.getFloat("precio"),
                    rs.getString("imagen"),
                    rs.getString("descripcion"),
                    rs.getBoolean("disponible"),
                    (CodigoDescuento) rs.getObject("codigoDescuento")
            );
            return Optional.of(producto);
        }
        db.close();
        return Optional.empty();
    }

    @Override
    public Producto save(Producto entity) throws SQLException {
        String sql = "INSERT INTO producto (uuid, nombre, precio, imagen, descripcion, disponible, codigoDescuento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        db.open();
        //TODO ¿Problemas con el UUID?
        var rs = db.insert(sql, entity.getUuid(), entity.getNombre(), entity.getPrecio(), entity.getImagen(), entity.getDescripcion(), entity.getDisponible(), entity.getCodigoDescuento());
        db.close();
        repository.add(entity);
        return entity;
    }

    @Override
    public Producto update(Producto entity) throws SQLException {
        int index = repository.indexOf(entity);
        String sql = "UPDATE producto SET uuid = ?, nombre = ?, precio = ?, imagen = ?, descripcion = ?, disponible = ?, codigoDescuento = ?)";
        db.open();
        //TODO ¿Problemas con el UUID?
        var rs = db.update(sql, entity.getUuid(), entity.getNombre(), entity.getPrecio(), entity.getImagen(), entity.getDescripcion(), entity.getDisponible(), entity.getCodigoDescuento());

        db.close();
        repository.set(index, entity);
        return entity;
    }

    @Override
    public Producto delete(Producto entity) throws SQLException {
        String sql = "DELETE FROM producto WHERE uuid = ?";
        db.open();
        var rs = db.delete(sql, entity.getUuid());
        db.close();
        repository.remove(entity);
        return entity;
    }

    @Override
    public void deleteAll() throws SQLException {
        String sql = "DELETE FROM producto";
        db.open();
        var rs = db.delete(sql);
        db.delete(sql);
    }
}