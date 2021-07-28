div_usuario = '<div class="row">' +
    '<div class="d-flex align-items-start">' +
    '<div class="flex-shrink-0">' +
    '<img ng-src="{{usuarioLogueado.avatar}}" alt="" height="100" width="100"' +
    'style="border-radius: 50%;">' +
    '</div>' +
    '<div class="flex-grow-1 ms-3" style="padding: 10px;">' +
    '<h3 ng-bind="nameUser"> </h3>' +
    '@<span ng-bind="nameUser"> </span>' +
    '</div>' +
    '<div class="justify-content-end" style="padding: 5px;">' +
    '<img src="edit.png" alt="" height="30" width="30"> Editar perfil' +
    '</div>' +
    '</div>' +
    '</div>' +
    '<div class="row" style="margin-top: 10px;">' +
    '<div class="col-12">' +
    '<ul class="nav nav-tabs justify-content-center">' +
    '<li class="nav-item">' +
    '<a class="nav-link active" aria-current="page" href="#"> Recetas </a>' +
    '</li>' +
    '<li class="nav-item">' +
    '<a class="nav-link" href="#"> Me gusta </a>' +
    '</li>' +
    '</ul>' +
    '</div>' +
    '</div>' +
    '<div style="margin-top: 15px; text-align: center;" ng-if="recetasUsuarioLog[0] === null">' +
    '<p> Ups... Parece que todavía no tienes ninguna receta :( </p>' +
    '<button class="btn btn-info btn-sm" ng-click="crearReceta();"> Agrega una! </button>' +
    '</div>' +
    '<div ng-repeat="rec in recetasUsuarioLog" ng-if="recetasUsuarioLog[0] !== null">' +
    '<div class="row d-flex justify-content-center" style="margin-top: 7px;">' +
    '<div class="col-7">' +
    '<div class="card mb-3" style="max-height: 150px;">' +
    '<div class="row g-0">' +
    '<div class="col d-flex align-items-center justify-content-center">' +
    '<img ng-src="{{rec.imagen}}" class="img-fluid rounded-start rounded-end" alt="..."' +
    'style="height: 130px; width: 90%;">' +
    '</div>' +
    '<div class="col-9">' +
    '<div class="card-header d-flex justify-content-between align-items-center"' +
    'style="padding-top: 0px; padding-bottom: 0px;">' +
    '<h5 class="card-title" style="margin-top: 8px;"> {{rec.titulo}} </h5>' +
    '<a href="" class="btn btn-outline-info btn-sm"> editar o borrar ?</a>' +
    '</div>' +
    '<div class="card-body">' +
    '<p class="card-text"> {{rec.descripcion}} </p>' +
    '<p class="card-text"><small class="text-muted"> Calificación ' +
    '{{rec.calificacion}} - {{rec.megustas}} Me' +
    'gusta</small></p>' +
    '</div>' +
    '</div>' +
    '</div>' +
    '</div>' +
    '</div>' +
    '</div>' +
    '</div>';

str_crear_cuenta = '<input type="text" placeholder="Nombre de usuario" ng-model="newuser"> <hr>' +
    '<input type="password" placeholder="Contraseña" ng-model="passw1"> <hr>' +
    '<input type="password" placeholder="Confirma contraseña" ng-model="passw2"> <hr>' +
    '<div style="text-align: center;">' +
    '<span style="font-size: 12px;"> Tenés cuenta? <a href=""' +
    'ng-click="cambiar_cont_modal(0);"> Inicia sesión! </a> </span>' +
    '</div> <div id="msj_modal" style="display: none;"> </div>';

str_inicio_sesion = '<input type="text" placeholder="Nombre de usuario" ng-model="user_inic"><hr>' +
    '<input type="password" placeholder="Contraseña" ng-model="passw_inic"><hr>' +
    '<div style="text-align: center;">' +
    '<a href="#" style="font-size: 12px;"> <span> Olvidaste tu contraseña? </span> </a> <br>' +
    '<span style="font-size: 12px;"> No tenés cuenta? <a href=""' +
    'ng-click="cambiar_cont_modal(1);"> Crea una! </a> </span>' +
    '</div> <div id="msj_modal" style="display: none;"> </div>';

str_btn_inic_ses = '<button type="button" class="btn btn-info btn-sm d-flex" data-bs-toggle="modal"' +
    'data-bs-target="#modalcito">' +
    '<img src="user.png" alt="" height="22" width="22" style="margin-right: 5px;">' +
    '<span style="vertical-align: middle;"> Ingresar / Registrarse </span>' +
    '</button>';

str_btn_u_logueado = '<div class="btn-group">' +
    '<button type="button" class="btn btn-sm btn-info d-flex ng-click="perfil();"> <span> {{nameUser}} </span> </button>' +
    '<button type="button" class="btn btn-sm btn-info dropdown-toggle dropdown-toggle-split"' +
    'data-bs-toggle="dropdown" aria-expanded="false">' +
    '<span class="visually-hidden">Toggle Dropdown</span>' +
    '</button>' +
    '<ul class="dropdown-menu">' +
    '<li> <button class="dropdown-item" type="button" ng-click="perfil();"> Ir a mi perfil </button> </li>' +
    '<li> <hr class="dropdown-divider"> </li>' +
    '<li> <button class="dropdown-item" type="button" ng-click="closeSesion();"> Cerrar sesión </button> </li>' +
    '</ul> </div>';

alert_congr_modal = '<div class="alert alert-success d-flex align-items-center" role="alert"' +
    'style="margin-bottom: 0px; padding: 2px; padding-left: 10px; margin-top: 3px;">' +
    '<svg class="bi flex-shrink-0 me-2" width="15" height="15" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>' +
    '<div> <span style="font-size: 12px; vertical-align: middle;"> Campos correctos </span> </div> </div>';

alert_error_modal = '<div class="alert alert-danger d-flex align-items-center" role="alert"' +
    'style="margin-bottom: 0px; padding: 2px; padding-left: 10px; margin-top: 3px;">' +
    '<svg class="bi flex-shrink-0 me-2" width="15" height="15" role="img" aria-label="Danger:">' +
    '<use xlink:href="#exclamation-triangle-fill"/> </svg>' +
    '<div> <span style="font-size: 12px; vertical-align: middle;"> Las contraseñas no coinciden </span> </div> </div>';

alert_null_user = '<div class="alert alert-danger d-flex align-items-center" role="alert"' +
    'style="margin-bottom: 0px; padding: 2px; padding-left: 10px; margin-top: 3px;">' +
    '<svg class="bi flex-shrink-0 me-2" width="15" height="15" role="img" aria-label="Danger:">' +
    '<use xlink:href="#exclamation-triangle-fill"/> </svg>' +
    '<div> <span style="font-size: 12px; vertical-align: middle;"> Usuario o contraseña incorrectos </span> </div> </div>';

div_inicio = '<div class="row">' +
    '<div class="col-3">' +
    '<table style="text-align: center;">' +
    '<tr> <td> Busca por receta </td> </tr>' +
    '<tr> <td> <input type="text" ng-model="busq" ng-keyup="buscar();"> </td> </tr>' +
    '<tr> <td> <hr> </td> </tr>' +
    '<tr> <td> Ordenar por: </td> </tr>' +
    '<tr> <td> <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">' +
    '<label class="form-check-label" for="flexCheckDefault"> Calificación </label> </td> </tr> </table> </div>' +
    '<div class="col-9" id="grillaRecetas">' +
    '<div class="row" ng-repeat="rece in Recetas track by $index" ng-if="$index % 4 === 0"' +
    'style="margin-top: 15px;">' +
    '<div class="col-3">' +
    '<div class="card text-center">' +
    '<img ng-src="{{Recetas[$index].imagen}}" class="card-img-top"' +
    'style="height: 130px; width: 100%;" alt="No se puede cargar la imagen">' +
    '<div class="card-body">' +
    '<h5 class="card-title"> {{Recetas[$index].titulo}} </h5>' +
    '<p class="card-text" style="height: 70px; font-size: 15px;">' +
    '{{Recetas[$index].descripcion}} </p> <p style="font-size: 12px;"> Calificación: {{Recetas[$index].calificacion}}</p>' +
    '<a href="" class="btn btn-primary btn-sm" ng-click="verRecetaActual($index);"> Ver receta </a>' +
    '</div> </div> </div>' +
    '<div class="col-3" ng-if="Recetas.length > ($index + 1)">' +
    '<div class="card text-center">' +
    '<img ng-src="{{Recetas[$index + 1].imagen}}" class="card-img-top"' +
    'style="height: 130px; width: 100%;" alt="No se puede cargar la imagen">' +
    '<div class="card-body">' +
    '<h5 class="card-title"> {{Recetas[$index + 1].titulo}} </h5>' +
    '<p class="card-text" style="height: 70px; font-size: 15px;"> {{Recetas[$index +' +
    '1].descripcion}} </p> <p style="font-size: 12px;"> Calificación: {{Recetas[$index+1].calificacion}}</p>' +
    '<a href="" class="btn btn-primary btn-sm" ng-click="verRecetaActual($index+1);"> Ver receta </a>' +
    '</div> </div> </div>' +
    '<div class="col-3" ng-if="Recetas.length > ($index + 2)">' +
    '<div class="card text-center">' +
    '<img ng-src="{{Recetas[$index + 2].imagen}}" class="card-img-top"' +
    'style="height: 130px; width: 100%;" alt="No se puede cargar la imagen">' +
    '<div class="card-body">' +
    '<h5 class="card-title"> {{Recetas[$index + 2].titulo}} </h5>' +
    '<p class="card-text" style="height: 70px; font-size: 15px;"> {{Recetas[$index +' +
    '2].descripcion}} </p> <p style="font-size: 12px;"> Calificación: {{Recetas[$index+2].calificacion}}</p>' +
    '<a href="" class="btn btn-primary btn-sm" ng-click="verRecetaActual($index+2);"> Ver receta </a>' +
    '</div> </div> </div>' +
    '<div class="col-3" ng-if="Recetas.length > ($index + 3)">' +
    '<div class="card text-center">' +
    '<img ng-src="{{Recetas[$index + 3].imagen}}" class="card-img-top"' +
    'style="height: 130px; width: 100%;" alt="No se puede cargar la imagen">' +
    '<div class="card-body">' +
    '<h5 class="card-title"> {{Recetas[$index + 3].titulo}} </h5>' +
    '<p class="card-text" style="height: 70px; font-size: 15px;"> {{Recetas[$index +' +
    '3].descripcion}} </p> <p style="font-size: 12px;"> Calificación: {{Recetas[$index+3].calificacion}}</p>' +
    '<a href="" class="btn btn-primary btn-sm" ng-click="verRecetaActual($index+3);"> Ver receta </a>' +
    '</div> </div> </div> </div> </div> </div>';

div_receta_act = '<div class="col-9">' +
    '<div class="row">' +
    '<div class="col" style="margin: 5px; text-align: center;">' +
    '<h1> {{recetaActual.titulo}} </h1> <hr>' +
    '</div> </div>' +
    '<div class="row">' +
    '<div class="col-6">' +
    '<h4> Ingredientes </h4>' +
    '<div class="list-group">' +
    '<label class="list-group-item" ng-repeat="ing in ingredientesActuales()">' +
    '<input class="form-check-input me-1" type="checkbox" value=""> {{ing}}</label>' +
    '</div> <hr> <h4> Preparación: </h4>' +
    '<div> <ol class="list-group list-group-numbered">' +
    '<li class="list-group-item d-flex justify-content-between align-items-start" ng-repeat="pas in pasosActuales()">' +
    '<div class="ms-2 me-auto"> <div> {{pas}} </div>' +
    '</div> </li> </ol> </div> </div>' +
    '<div class="col-6 text-center" style="padding-bottom: 10px;">' +
    '<div class="d-flex justify-content-center">' +
    '<img ng-src="{{recetaActual.imagen}}" alt="No se puede mostrar la imagen" style="height: auto; width: auto;">' +
    '</div> <hr>' +
    '<h5> Calificación = {{recetaActual.calificacion}} </h5> <hr>' +
    '<h5> Votar: </h5> <hr>' +
    '<h5> Duración: {{recetaActual.duracion}} </h5> <hr>' +
    '<h5> Receta creada por: @{{recetaActual.usuarioCreador}} </h5>' +
    '</div> </div> </div>';

div_crear_receta = '<div class="col-9"> <form> <br> <div class="form-group row">' +
    '<div class="col-3 d-flex justify-content-center align-items-center"' +
    'style="margin-left: 12px; border-width: 1px; border-color: rgba(0, 0, 0, 0.568); border-style: solid; border-radius: 20px;">' +
    '<div class="image-upload">' +
    '<label for="in_file"> <span>Sube una foto de tu receta </span> <br>' +
    '<img src="imagen.png" alt="Click en el botón" style="margin-left: 17%; margin-top: 5px;"' +
    'ng-model="img" id="img"> </label>' +
    '<input type="file" class="form-control-file" ng-model="in_file" id="in_file"' +
    'onchange="angular.element(this).scope().fileSelected(this)"> </div> </div> <div class="col">' +
    '<center><label for="in_titulo" style="font-size:x-large; margin-bottom: 3px;"> Título </label> </center>' +
    '<input type="text" class="form-control" ng-model="in_titulo"' +
    'placeholder="Escriba aquí el título de su maravillosa receta" style="font-size:large; text-align:center;">' +
    '</div> </div> <br> <div class="form-group row">' +
    '<div class="col-4"> <label>Descripción</label> <br> <textarea ' +
    'placeholder="Cuéntanos un poco más acerca de tu receta. Ya sabes, lo típico de &apos;Es una receta de mi abuela&apos;..."' +
    'style="width:100%;height:100px; border-radius: 4px;"' +
    'ng-model="in_descripcion"></textarea> </div> <div class="col-4"> <label>Ingredientes</label>' +
    '<table> <tr ng-repeat="inp in inputs track by $index"> <td>' +
    '<input type="text" class="form-control" ng-model="Ingredientes[$index]"' +
    'placeholder="Ej. 100 ml de aceite"> </td> <td>' +
    '<button type="button" class="btn btn-danger" style="margin-left: 20%;"' +
    'ng-click="eliminar($index, 0)">Eliminar</button>' +
    '</td> </tr> </table> <br>' +
    '<button type="button" class="btn btn-secondary" style="margin-left: 10%;"' +
    'ng-click="mas_ingrediente($index)">Agregar otro ingrediente</button> </div>' +
    '<div class="col-4"> <label for="in_pasos">Pasos</label>' +
    '<table> <tr ng-repeat="inp2 in inputs2 track by $index"> <td>' +
    '<input type="text" class="form-control" ng-model="Pasos[$index]"' +
    'placeholder="Dinos qué hacer"> </td> <td>' +
    '<button type="button" class="btn btn-danger" style="margin-left: 20%;"' +
    'ng-click="eliminar($index, 1)">Eliminar</button>' +
    '</td> </tr> </table> <br>' +
    '<button type="button" class="btn btn-secondary" style="margin-left: 20%;"' +
    'ng-click="mas_paso($index)">Agregar otro paso</button>' +
    '</div> </div> <br>' +
    '<div class="form-group row"> <div class="col">' +
    '<label for="in_duracion">Duración</label>' +
    '<input type="text" class="form-control" ng-model="in_duracion" placeholder="00:00:00">' +
    '</div> <div class="col">' +
    '<label for="in_dificultad">Dificultad</label>' +
    '<select ng-model="in_dificultad" class="form-control">' +
    '<option selected>Fácil</option>' +
    '<option>Media</option>' +
    '<option>Difícil</option>' +
    '</select> </div> <div class="col">' +
    '<label for="in_categoria">Categoría</label>' +
    '<select ng-model="in_categoria" class="form-control">' +
    '<option selected value="1">Postres</option>' +
    '<option value="2">Desayuno</option>' +
    '<option value="3">Almuerzo</option>' +
    '<option value="4">Merienda</option>' +
    '<option value="5">Cena</option>' +
    '<option value="6">Salado</option>' +
    '<option value="7">Batidos</option>' +
    '<option value="8">Bebidas</option>' +
    '<option value="9">Aperitivos</option>' +
    '</select> </div> </div> <br> <div class="row">' +
    '<div class="col d-flex justify-content-center">' +
    '<button type="button" class="btn btn-success btn-lg" ng-click="enviar();">Publicar</button>' +
    '</div> </div> </form> </div>';