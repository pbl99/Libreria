# Librería App

## Descripción
Librería es una aplicación que simula una librería virtual donde los usuarios pueden explorar y comprar libros. La aplicación ofrece funciones de registro y login para gestionar las cuentas de los usuarios, así como un menú para navegar por diferentes categorías de libros y audiolibros.

## Estructura del Proyecto

libreria-app/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── palmen/
│ │ │ └── libreria/
│ │ │ ├── app/
│ │ │ │ └── LibreriaMain.java # Punto de entrada principal de la aplicación
│ │ │ ├── controllers/
│ │ │ │ ├── LibreriaMainController.java # Controlador para la vista principal
│ │ │ │ ├── LoginController.java # Controlador para la vista de login
│ │ │ │ ├── RegistroController.java # Controlador para la vista de registro
│ │ │ │ ├── InicioController.java # Controlador para la vista de Inicio
│ │ │ │ ├── AudioLibrosController.java # Controlador para la vista de audiolibros
│ │ │ │ ├── CategoriasController.java # Controlador para la vista de categorías
│ │ │ │ └── MiCuentaController.java # Controlador para la vista de cuenta del usuario
│ │ │ └── utilities/
│ │ │ └── VentanaUtil.java # Clase utilitaria para la gestión de ventanas
│ │ ├── resources/
│ │ │ ├── com/
│ │ │ │ └── palmen/
│ │ │ │ └── libreria/
│ │ │ │ ├── controllers/
│ │ │ │ │ ├── LibreriaMainView.fxml # Vista principal de la librería en FXML
│ │ │ │ │ ├── LoginView.fxml # Vista de login en FXML
│ │ │ │ │ ├── RegistroView.fxml # Vista de registro en FXML
│ │ │ │ │ ├── AudioLibrosView.fxml # Vista de audiolibros en FXML
│ │ │ │ │ ├── CategoriasView.fxml # Vista de categorías en FXML
│ │ │ │ │ ├── MiCuentaView.fxml # Vista de cuenta del usuario en FXML
│ │ │ │ │ └── InicioView.fxml # Vista de inicio en FXML
│ │ │ │ └── css/
│ │ │ │ └── styles.css # Hoja de estilos CSS para la aplicación
│ └── test/ # Directorio para pruebas (opcional)
│
└── README.md # Documentación del proyecto

## Configuración Básica

### Tecnologías Utilizadas
- JavaFX para la interfaz de usuario
- CSS para estilizar la interfaz
- Maven para la gestión de dependencias

### Puntos Destacados
- **Controladores**: Los controladores (`LibreriaMainController`, `LoginController`, `RegistroController`, `AudioLibrosController`, `CategoriasController`, `MiCuentaController`) manejan la lógica de negocio y la interacción con las vistas.
- **FXML**: Archivos FXML (`LibreriaMainView.fxml`, `LoginView.fxml`, `RegistroView.fxml`, `AudioLibrosView.fxml`, `CategoriasView.fxml`, `MiCuentaView.fxml`, `InicioView.fxml`) definen la estructura de las interfaces de usuario.
- **VentanaUtil**: Clase utilitaria (`VentanaUtil.java`) para la gestión de ventanas y eventos de la interfaz.
- **CSS**: Hoja de estilos (`styles.css`) para personalizar la apariencia de la aplicación.

## Uso
1. Clona el repositorio desde GitHub: `git clone https://github.com/pbl99/libreria.git`
2. Abre el proyecto en tu IDE favorito.
3. Configura las dependencias y asegúrate de tener JavaFX configurado correctamente si es necesario.
4. Ejecuta `LibreriaMain.java` para iniciar la aplicación.

## Contribución
- Si deseas contribuir al proyecto, realiza un fork y envía un pull request con tus cambios.
- Asegúrate de seguir las convenciones de codificación y las prácticas recomendadas.

## Licencia
Este proyecto está bajo la licencia [MIT](https://opensource.org/licenses/MIT).
