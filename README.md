## Notes App 
Amada Noemi Cárcamo Renderos 
### MVVM
- **Modelo (Note.kt):** define la entidad Nota.
- **ViewModel (NoteViewModel):** mantiene el estado y la lógica.
- **Vista (MainScreen, MainActivity):** muestra datos y envía eventos al ViewModel.
  
### Capturas
Paso 1: Configuramos el build.gradle

![Paso 1: Configuramos el build.gradle](Imagenes/1.jpg)

Paso 2: Crear carpeta del model y crear la clase Note 

![paso 2](Imagenes/2.jpg)
![paso 2](Imagenes/3.jpg)

Paso 3: Crear el paquete vm

![paso 3](Imagenes/4.jpg)

•Agregamos NoteViewModel.kt con todas sus funcionalidades 

![paso 3](Imagenes/5.jpg)

Paso 4: Modificamos el Main Activity.kt

![paso 4](Imagenes/6.jpg)

Paso 5: Creamos el MainSreen.kt 

![paso 5](Imagenes/7.jpg)
![paso 5](Imagenes/8.jpg)
![paso 5](Imagenes/9.jpg)
![paso 5](Imagenes/10.jpg)

Paso 6: Aplicacion ejecutandose 

![paso 6](Imagenes/11.jpg)

•	Presiona Agregar → debe aparecer en la lista

![paso 6](Imagenes/12.jpg)

•	Notas agregadas 

![paso 6](Imagenes/13.jpg)

•	Presiona Eliminar → debe desaparecer.

![paso 6](Imagenes/14.jpg)

•	Pruebas al rotar la pantalla 

![paso 6](Imagenes/19.jpg)


### Errores
Error 1: Error generado por utilizar llaves 

![error1](Imagenes/15.jpg)

Solucion: Colocar parentesis en lugar de las llaves 

![error1](Imagenes/16.jpg)

Error 2: Unresolved reference: 'MainScreen'-significa que todavía no existe ninguna funcion con el nombre MainSreen 

![error2](Imagenes/17.jpg)

Solucion: Crear el MainScreen

![error2](Imagenes/18.jpg)



