-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: cookey
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE SCHEMA IF NOT EXISTS `cookey` DEFAULT CHARACTER SET utf8 ;
USE `cookey` ;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta` (
  `idreceta` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `ingredientes` text,
  `pasos` text,
  `duracion` varchar(45) DEFAULT NULL,
  `dificultad` varchar(45) DEFAULT NULL,
  `imagen` varchar(100) DEFAULT NULL,
  `comentarios` json DEFAULT NULL,
  `megustas` int DEFAULT NULL,
  `calificacion` float DEFAULT NULL,
  `fecha_publi` date DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `usuario_creador` varchar(45) NOT NULL,
  PRIMARY KEY (`idreceta`),
  KEY `fk_receta_usuarios_idx` (`usuario_creador`),
  CONSTRAINT `fk_receta_usuarios` FOREIGN KEY (`usuario_creador`) REFERENCES `usuarios` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (1,'Tacos','tacos de pollo','fajitas,pollo','preparar,comer','00:30:00','Facil','tacos.jpeg',NULL,10,4.2,'2021-07-25','Almuerzo','Leonel'),(3,'Guiso de arroz','Ideal para los dias de invierno','400 gr de carne,4 tazas de arroz,1 zanahoria mediana,1 cebolla mediana,1 pimiento rojo,1 lata de pure de tomate,Agua,2 hojas de laurel,1 diente de ajo,sal,aceite','Sofreir en una olla la cebolla, ajo y pimiento cortados muy chiquitos,Agregar la carne, zanahoria cortada en cubitos y dejar cocinar por 2 minutos a fuego lento,Condimentar y mezclar. Dejar cocinar a fuego lento hasta que la carne se dore,Agregar el pure de tomate y agua hasta que comience a hervir,Agregar el arroz hasta que est%C3%A9 al dente (20 minutos aprox)','01:00:00','Media','dsc-0142.jpg',NULL,NULL,2,'2021-07-28','Almuerzo','Eliana'),(4,'Huevos revueltos','Receta ideal para cuando el tiempo es un recurso limitado','Aceite,2 huevos medianos,1 cebolla mediana','Cortar la cebolla en juliana,Sofreir la cebolla en una sarten,Batir en un bolw los huevos con un poco de sal y condimentos a gusto,Cuando la cebolla empiece a dorarse, agregar los huevos batidos y mezclar energicamente,Retirar del fuego la sarten cuando los huevos esten cocidos','00:15:00','Facil','4.jpg',NULL,NULL,5,'2021-07-28','Almuerzo','Eliana'),(5,'Licuado de durazno','La receta rinde para 3 vasos aproximadamente','3 duraznos maduros,500 cc de leche fria,Endulzante a gusto','Lavar y descarozar los duraznos,Colocar los duraznos en la licuadora junto con algunos cubitos de hielo,Agregar la leche y el endulzante,Licuar a maxima velocidad','00:10:00','Facil','8b8902502a3e2df0cf03c22801b98dde.jpg',NULL,NULL,5,'2021-07-28','Batidos','Eliana'),(6,'Bebida instant','Inventamos esta receta con mis amigos para tener mas energia en nuestros entrenamientos','2 cucharadas de cacao dulce (yo uso chocolino),3 cucharaditas de cafe,Endulzante a gusto,Leche,Hielo','Agregar en un vaso el cacao, cafe y endulzante,Agregar un poquito de leche y batir,Seguir batiendo mientras agregas un poco mas de leche,Agregar hielo,Agregar leche hasta terminar de llenar el vaso','00:05:00','Facil','el-vascolet-en-polvo-con___qzBhU7Fnt_1200x630__1.jpg',NULL,NULL,4,'2021-07-28','Bebidas','Eliana'),(7,'Bizcochuelo de coco','Delicioso bizcochuelo de leche de coco','2 tazas y media de leche de coco,4 tazas de harina,1 taza y media de azucar,260 ml de aceite,6 huevos,14 gr de levadura quimica','Batir los huevos con una batidora electrica,Cuando los huevos esten espumosos, agregar la leche y seguir batiendo,Agregar el aceite y seguir batiendo,Finalmente agregar la harina junto con la levadura e incorporarla con una espatula hasta que quede una masa homogenea,Enharinar y enmantecar el molde. Verter la mezcla en el molde,Hornear por aproximadamente 1 hora, o hasta que al pinchar el centro del bizcochuelo comprobemos que no est%C3%A9 humedo','01:30:00','Facil','c7cebe7f-3855-44b8-8709-7e99df17c246-600.jpg',NULL,NULL,3,'2021-07-28','Merienda','Eliana'),(8,'Panqueques integrales','Deliciosos panqueques integrales para contrarrestar los efectos de la cuarentena','300 gr de harina integral,2 huevos,250 ml de leche','Mezclar los huevos,Agregar la leche y batir,Agregar la harina y batir,La consistencia debe ser algo espesa, por lo que hay que ir agregando harina o leche segun sea necesario,Enmantecar la sarten y con un cucharon de sopa agregar un poco de la mezcla en la sarten mientras se toma el mango del mismo para esparcir la mezcla por toda la sarten,Cada 3 panqueques volver a enmantecar la sarten','00:20:00','Facil','c28aee038c164303d0e45fb1c396e194.jpg',NULL,NULL,3.5,'2021-07-28','Merienda','Jere'),(9,'Pochoclos de cine','Despues de probar innumerables recetas, encontre la indicada','media taza de maiz pisingallo,3 cucharadas de azucar,1 cucharada de miel,2 cucharadas de mantecas,1 pizca de sal,aceite,1 cucharadita de esencia de vainilla','En una olla antiadherente poner la manteca, azucar, miel y esencia de vainilla, y un chorrito de aceite. Llevar al fuego y revolver para que no se pegue,Cuando haga muchas burbujas revolver sin parar por un minuto y apagar el fuego,En otra olla colocar un fondo de aceite y esperar a que se caliente por un minuto,Agregar el maiz pisingallo con la sal,Poner la tapa en la olla y cada tanto sacudir la olla para que no se peguen,Cuando ya no se escuchen casi explosiones, apagar el fuego y dejar la olla tapada,Poner la primera mezcla sobre los pochoclos y revolver energicamente para cubrirlos a todos','00:15:00','Facil','pochoclos.jpeg',NULL,NULL,4.5,'2021-07-28','Aperitivos','Dalila'),(10,'Lomito con papas','Tremendo lomo con papas para compartir con amigos!','Lomito de delivery del barato,Gaseosa','Comer,Disfrutar :)','00:45:00','Dificil','lomitos.jpg',NULL,NULL,NULL,'2021-07-29','Cena','Prueba');
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `nombre_usuario` varchar(45) NOT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  `avatar` varchar(150) DEFAULT NULL,
  `cant_recetas` int DEFAULT NULL,
  `prom_calif` float DEFAULT NULL,
  PRIMARY KEY (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Afsa','leo',NULL,NULL,NULL),('Agente47m','agentecito:3',NULL,NULL,NULL),('Ares','eli',NULL,NULL,NULL),('Dalila','leo',NULL,NULL,NULL),('Dani050','danielcito',NULL,NULL,NULL),('domingogallardo','dominguete',NULL,NULL,NULL),('Eliana','eli123',NULL,NULL,NULL),('ghf','hgf','lomitos.jpg',NULL,NULL),('Jere','hola',NULL,NULL,NULL),('jokotto','jeppeta',NULL,NULL,NULL),('JonOaks','johnnybravo',NULL,NULL,NULL),('Josrom','contra123',NULL,NULL,NULL),('Leonel','leito:3','avatar.jpeg',1,4.2),('Prueba','prueba','avatar.jpeg',NULL,NULL),('Roberto','lele',NULL,NULL,NULL),('tal','leo',NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-29  0:20:05
