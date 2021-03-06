var app = angular.module("cookeycito", []);
app.controller("controlador", function ($scope, $http, $compile) {

    $scope.Recetas = [];
    $scope.recetaActual = {};
    $scope.usuarioLogueado = {};
    $scope.recetasUsuarioLog = [];
    $scope.recetaCreada = {};
    $scope.nameUser = '';
    $scope.head_modal = 'Loguearse en Cookey';
    $scope.btn_modal = 'Ingresar';
    $scope.inic_o_crear = 0;
    $scope.editar = 0;
    $scope.tituloAnt;
    $scope.avatarNuevo;
    $scope.resource;

    $scope.ingredientesActuales = function () {
        return $scope.recetaActual.ingredientes.split(",");
    }

    $scope.pasosActuales = function () {
        return $scope.recetaActual.pasos.split(",");
    }

    $scope.fileSelected_2 = function (element) {
        var myFileSelected = element.files[0];
        console.log(myFileSelected);
        $scope.avatarNuevo = element.files[0].name;
        console.log($scope.avatarNuevo);
        $scope.resource = URL.createObjectURL(myFileSelected);
        document.getElementById("img2").src = $scope.resource;
    }

    // Parte registrar receta
    $scope.Ingredientes = [];
    $scope.Pasos = [];
    $scope.objectURL;
    $scope.inputs = [];
    $scope.inputs2 = [];

    $scope.mas_ingrediente = function () {
        $scope.inputs.push(0);
        console.log("---------------- " + $scope.Ingredientes[$scope.Ingredientes.length - 1]);
        $scope.Ingredientes.push($scope.Ingredientes[$scope.inputs.length]);
        console.log($scope.Ingredientes);
    }

    $scope.mas_paso = function () {
        $scope.inputs2.push(0);
        console.log("---------------- " + $scope.Pasos[$scope.Pasos.length - 1]);
        $scope.Pasos.push($scope.Pasos[$scope.inputs2.length]);
        console.log($scope.Pasos);
    }

    $scope.fileSelected = function (element) {
        var myFileSelected = element.files[0];
        console.log(myFileSelected);
        $scope.objectURL2 = element.files[0].name;
        $scope.objectURL = URL.createObjectURL(myFileSelected);
        document.getElementById("img").src = $scope.objectURL;
    }

    $scope.eliminar = function (index, par) {
        if (par == 0) {
            $scope.Ingredientes.splice(index, 1);
            $scope.inputs.pop(0);
            console.log($scope.Ingredientes);
            console.log("Eliminar ingrediente");
        } else if (par == 1) {
            $scope.Pasos.splice(index, 1);
            $scope.inputs2.pop(0);
            console.log($scope.Pasos);
            console.log("Eliminar paso");
        }
    }

    $scope.enviar = function () {

        // Comprobar que los datos sean v??lidos:
        if ($scope.in_titulo == null) {
            swal("Oops!", "Parece que no nos dijiste cu??l es el t??tulo de tu receta", "error");
            return;
        }
        if ($scope.Ingredientes.length <= 0) {
            swal("Oops!", "??C??mo podemos recrear tu receta si no nos dices cu??les son los ingredientes?", "error");
            return;
        } else {
            for (i = 0; i < $scope.Ingredientes.length; i++) {
                if ($scope.Ingredientes[i] == null) {
                    $scope.eliminar(i, 0);
                    console.log("Eliminando ingrediente vac??o.");
                }
            }
        }

        if ($scope.Pasos.length <= 0) {
            swal("Oops!", "??C??mo podemos recrear tu receta si no nos dices cu??les son los pasos?", "error");
            return;
        } else {
            for (i = 0; i < $scope.Pasos.length; i++) {
                if ($scope.Pasos[i] == null) {
                    $scope.eliminar(i, 1);
                    console.log("Eliminando paso vac??o.");
                }
            }
        }

        if ($scope.in_duracion == null) {
            swal("Oops!", "??Te olvidaste de indicarnos la duraci??n aproximada de tu receta?", "error");
            return;
        }

        //Comprobar ac?? que el formato sea 00:00:00
        dur = $scope.in_duracion.split(":");
        if (dur.length != 3) {
            swal("Cuidado", "El formato de la duraci??n debe ser del tipo 00:00:00", "warning");
            return;
        }
        var valoresAceptados = /^[0-9]+$/;
        for (i = 0; i < dur.length; i++) {
            if (!dur[i].match(valoresAceptados)) {
                swal("Oops!", "Este campo solo acepta n??meros y :", "error");
                return;
            }
        }

        if ($scope.in_dificultad == null) {
            swal("Oops!", "??Cu??l es la dificultad de tu receta?", "error");
            return;
        }

        if ($scope.in_categoria == null) {
            swal("Oops!", "??No te olvides de elegir la categor??a de la receta!", "error");
            return;
        }

        titulo = $scope.in_titulo;
        descripcion = $scope.in_descripcion; //Ver c??mo Java recibe la descripci??n cuando sea undefined (nula)
        ingredientes = $scope.Ingredientes;
        pasos = $scope.Pasos;
        duracion = $scope.in_duracion;
        dificultad = $scope.in_dificultad;
        categoria = $scope.in_categoria;
        img = $scope.objectURL2;
        usuarioCrea = $scope.usuarioLogueado.nombreUsuario;

        // Elementos de una receta: TITULO - DESCRIPCION (O) - 
        // INGREDIENTES - PASOS - DURACION - DIFICULTAD - CATEGORIA
        // IMAGEN - COMENTARIOS? - MEGUSTAS - CALIFICACION
        // FECHA PUBLICACION - USUARIO CREADOR

        if ($scope.editar === 0) {
            str_http = "http://localhost:8866/RegistrarR/?titulo=" + titulo + "&descripcion=" + descripcion + "&ingredientes=" + ingredientes +
            "&pasos=" + pasos + "&duracion=" + duracion + "&categoria=" + categoria + "&imagen=" + img +
            "&usuarioCrea=" + $scope.usuarioLogueado.nombreUsuario + "&dificultad=" + dificultad;
        } else if ($scope.editar === 1) {
            str_http = "http://localhost:8866/ActualizarR/?titulo=" + titulo + "&descripcion=" + descripcion + "&ingredientes=" + ingredientes +
            "&pasos=" + pasos + "&duracion=" + duracion + "&categoria=" + categoria + "&imagen=" + img + "&dificultad=" + dificultad + 
            "&tituloAnt=" + $scope.tituloAnt + "&user=" + $scope.usuarioLogueado.nombreUsuario;
            $scope.editar = 0;
        }

        console.log("T??tulo: " + $scope.in_titulo + ". Descripci??n: " + $scope.in_descripcion + ". Ingredientes: " + $scope.Ingredientes + ". Pasos: " + $scope.Pasos +
            ". Duraci??n: " + $scope.in_duracion + ". Dificultad: " + $scope.in_dificultad + ". Categor??a: " + $scope.in_categoria + ". Imagen: " +
            $scope.objectURL2);

        $http.get(str_http).success(response => {
            $scope.recetaCreada = response[0]; console.log(response);
        });

        setTimeout(function () {

            if ($scope.recetaCreada !== null) {
                alert("Receta creada/actualizada con exito!");
                $scope.listado();
                $scope.loadRecUser();
                $scope.perfil();
                $scope.clearCrear();
            }
        }, 1500);

        console.log($scope.recetaCreada);
    }

    // Fin

    $scope.clearCrear = function () {
        $scope.Ingredientes = [];
        $scope.Pasos = [];
        $scope.objectURL;
        $scope.inputs = [0];
        $scope.inputs2 = [0];

        $scope.in_titulo = "";
        $scope.in_descripcion = "";
        $scope.in_duracion = "";
        $scope.in_dificultad = "";
        $scope.in_categoria = "";
        $scope.objectURL2 = "";
    }

    $scope.editarRec = function (ind) {
        $scope.crearReceta();

        $scope.editar = 1;
        $scope.tituloAnt = $scope.recetasUsuarioLog[ind].titulo;
        $scope.Ingredientes = $scope.recetasUsuarioLog[ind].ingredientes.split(",");
        $scope.Pasos = $scope.recetasUsuarioLog[ind].pasos.split(",");
        document.getElementById("img").src = $scope.recetasUsuarioLog[ind].imagen;
        for (var i = 0; i < $scope.Ingredientes.length - 1; i++) {
            $scope.inputs.push(0);
        }
        for (var i = 0; i < $scope.Pasos.length - 1; i++) {
            $scope.inputs2.push(0);
        }

        $scope.in_titulo = $scope.recetasUsuarioLog[ind].titulo;
        $scope.in_descripcion = $scope.recetasUsuarioLog[ind].descripcion;
        $scope.in_duracion = $scope.recetasUsuarioLog[ind].duracion;
        $scope.in_dificultad = $scope.recetasUsuarioLog[ind].dificultad;
        $scope.in_categoria = $scope.recetasUsuarioLog[ind].categoria;

        
    }

    $scope.eliminarRec = function (ind) {
        cond = confirm("Esta seguro de eliminar la receta " + $scope.recetasUsuarioLog[ind].titulo + " ?");
        if (cond === true) {
            str_http = "http://localhost:8866/EliminarReceta/?titulo=" + $scope.recetasUsuarioLog[ind].titulo + 
                "&usuarioCrea=" + $scope.recetasUsuarioLog[ind].usuarioCreador;
            $http.get(str_http)
                .success(response => {
                    $scope.recetasUsuarioLog = response; console.log(response);
                });
            $scope.listado();
            $scope.perfil();
        } 
    }

    $scope.inicio = function () {
        if (localStorage.getItem("usuarioLogueado")) {
            $scope.usuarioLogueado = JSON.parse(localStorage.getItem("usuarioLogueado"));
            $scope.nameUser = $scope.usuarioLogueado.nombreUsuario;
            $scope.logueado_deslogueado(true);

            $http.get("http://localhost:8866/ListarRecetasUser/?user=" + $scope.usuarioLogueado.nombreUsuario)
                .success(response => {
                    $scope.recetasUsuarioLog = response; console.log(response);
                });
        }

        $http.get("http://localhost:8866/ListarRecetas").success(response => {
            $scope.Recetas = response; console.log(response);
        });

        console.log("Ingredientes = " + $scope.Ingredientes.length);
        $scope.inputs = [0];
        $scope.inputs2 = [0];
    }

    $scope.listado = function () {
        $http.get("http://localhost:8866/ListarRecetas").success(response => {
            $scope.Recetas = response; console.log(response);
        });
    }

    $scope.loadRecUser = function () {
        $http.get("http://localhost:8866/ListarRecetasUser/?user=" + $scope.usuarioLogueado.nombreUsuario)
            .success(response => {
                $scope.recetasUsuarioLog = response; console.log(response);
            });
    }

    $scope.compilar_element = function (id) { $compile(document.getElementById(id))($scope); }

    $scope.cambiar_cont_modal = function (tip) {
        cont_modal = document.getElementById("contenido_modal");

        if (tip === 0) {
            $scope.head_modal = 'Loguearse en Cookey';
            $scope.btn_modal = 'Ingresar';
            cont_modal.innerHTML = str_inicio_sesion;
            $scope.inic_o_crear = 0;
            $compile(cont_modal)($scope);
        }

        if (tip === 1) {
            $scope.head_modal = 'Registrarse en Cookey';
            $scope.btn_modal = 'Registrarse';
            cont_modal.innerHTML = str_crear_cuenta;
            $scope.inic_o_crear = 1;
            $compile(cont_modal)($scope);
        }
    }

    $scope.logueado_deslogueado = function (opt) {
        btn_user = document.getElementById("sesion");
        opt ? btn_user.innerHTML = str_btn_u_logueado : btn_user.innerHTML = str_btn_inic_ses;
        $compile(document.getElementById("sesion"))($scope);
        $scope.nameUser = $scope.usuarioLogueado.nombreUsuario;
    }

    $scope.saveLogin = function () {
        localStorage.setItem("usuarioLogueado", JSON.stringify($scope.usuarioLogueado));
    }

    $scope.clear = function () {
        $scope.user_inic = '';
        $scope.passw_inic = '';
        $scope.newuser = '';
        $scope.passw1 = '';
        $scope.passw2 = '';
    }

    $scope.closeSesion = function () {
        localStorage.removeItem("usuarioLogueado");
        alert("Se cerr?? la sesi??n con exito!");
        $scope.logueado_deslogueado(false);
        $scope.pagInicio();
    }

    $scope.verif_datos_inic_ses = function () {
        msj_moda = document.getElementById("msj_modal");

        if ($scope.inic_o_crear === 0) {

            i1 = false; i2 = false; i3 = false;
            if ($scope.user_inic === undefined) { $scope.mostrar_and_innerhtml(msj_moda, alert_error_modal); }
            else { i1 = true; }

            if ($scope.passw_inic === undefined) { $scope.mostrar_and_innerhtml(msj_moda, alert_error_modal); }
            else { i2 = true; }

            if (i1 && i2) {

                str_http = "http://localhost:8866/Ingresar/?user=" + $scope.user_inic + "&passw=" +
                    $scope.passw_inic;

                $http.get(str_http).success(response => {
                    $scope.user_response = response; console.log(response);

                    if ($scope.user_response[0] === null) {
                        $scope.mostrar_and_innerhtml(msj_moda, alert_null_user);
                        $scope.showhideModal(true);
                        return;
                    }

                    if ($scope.user_response !== undefined) {
                        if ($scope.user_response.length !== 0 && $scope.user_response !== null) {
                            console.log("entre ac??");
                            $scope.usuarioLogueado = $scope.user_response[0];
                            $scope.nameUser = $scope.usuarioLogueado.nombreUsuario;
                            $scope.saveLogin();
                            $scope.mostrar_and_innerhtml(msj_moda, alert_congr_modal);
                        }
                    }
                });

            }

            setTimeout(function () {

                $scope.clear();
                if ($scope.user_response[0] !== null) {
                    $scope.logueado_deslogueado(true);
                    console.log("pase por ac??");
                    $scope.showhideModal(false);
                    $scope.$apply();
                    $scope.loadRecUser();
                }
            }, 1500);

        }

        if ($scope.inic_o_crear === 1) {

            i1 = false; i2 = false; i3 = false;
            if ($scope.newuser === undefined) { $scope.mostrar_and_innerhtml(msj_moda, alert_error_modal); }
            else { i1 = true; }

            if ($scope.passw1 === undefined || $scope.passw2 === undefined) {
                $scope.mostrar_and_innerhtml(msj_moda, alert_error_modal);
            } else { i2 = true; }

            if ($scope.passw1 !== $scope.passw2) {
                $scope.mostrar_and_innerhtml(msj_moda, alert_error_modal);
            } else { i3 = true; }

            if (i1 && i2 && i3) {

                str_http = "http://localhost:8866/RegistrarU/?newUserName=" + $scope.newuser + "&newPassw=" +
                    $scope.passw2 + "&avatar=" + $scope.avatarNuevo;

                $http.get(str_http).success(response => {
                    $scope.user_response = response; console.log(response);

                    if ($scope.user_response !== undefined) {
                        if ($scope.user_response.length !== 0 && $scope.user_response !== null) {
                            $scope.usuarioLogueado = $scope.user_response[0];
                            $scope.nameUser = $scope.usuarioLogueado.nombreUsuario;
                            $scope.saveLogin();
                            $scope.mostrar_and_innerhtml(msj_moda, alert_congr_modal);
                            alert("Bienvenido a Cookey!");
                        }
                    }
                });

                setTimeout(function () {

                    if ($scope.user_response[0] !== null) {
                        $scope.clear();
                        $scope.logueado_deslogueado(true);
                        console.log("pase por ac??");
                        $scope.showhideModal(false);
                        $scope.$apply();
                        $scope.loadRecUser();
                    }
                }, 1500);
            }

        }
    }

    $scope.perfil = function () {
        document.getElementById("contenidoCambio").innerHTML = div_usuario;
        $scope.compilar_element("contenidoCambio");
    }

    $scope.verRecetaActual = function (ind) {
        $scope.recetaActual = $scope.Recetas[ind];
        document.getElementById("contenidoCambio").innerHTML = div_receta_act;
        $scope.compilar_element("contenidoCambio");
    }

    $scope.pagInicio = function () {
        document.getElementById("contenidoCambio").innerHTML = div_inicio;
        $scope.compilar_element("contenidoCambio");
    }

    $scope.mostrar_and_innerhtml = function (element, contenido) {
        element.innerHTML = contenido;
        element.style.display = "block";
        setTimeout(function () { element.innerHTML = ''; element.style.display = 'none'; }, 5000);
        console.log("cambie");
    }

    $scope.showhideModal = function (opt) {
        opt ? $('#modalcito').modal('show') : $('#modalcito').modal('hide');
    }

    $scope.crearReceta = function () {
        document.getElementById("contenidoCambio").innerHTML = div_crear_receta;
        $scope.compilar_element("contenidoCambio");
    }

    $scope.buscar = function () {
        if ($scope.busq === undefined || $scope.busq === "") {
            $scope.listado();
        } else {
            $http.get("http://localhost:8866/BuscarR/?criterio=" + $scope.busq)
                .success(response => {
                    $scope.Recetas = response; console.log(response);

                    if ($scope.user_response[0] === null) {
                        $scope.Recetas = [];
                    }
                });

        }
    }

    $scope.ordenar = function () {
        if ($scope.ordCalif) {
            $scope.Recetas.sort(function (a, b) {
                if (a.calificacion < b.calificacion) return 1;
                else if (a.calificacion > b.calificacion) return -1;
                return 0;
            });
        }
    }



});