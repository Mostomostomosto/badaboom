-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.72-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema comics
--

CREATE DATABASE IF NOT EXISTS comics;
USE comics;

--
-- Definition of table `autor`
--

DROP TABLE IF EXISTS `autor`;
CREATE TABLE `autor` (
  `cod_autor` int(5) NOT NULL,
  `nom_autor` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `autor`
--

/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` (`cod_autor`,`nom_autor`) VALUES 
 (1,'John Layman'),
 (2,'Andy Diggle'),
 (3,'Paul Dini'),
 (4,'grant Morrison'),
 (5,'Chris Burnham '),
 (6,'Jonathan Hickman'),
 (7,'Dan Slott'),
 (8,'Jeph Loeb'),
 (9,'Kate Leth'),
 (10,'Mark Waid'),
 (11,'Robert Kirkman'),
 (12,'Mark Millar'),
 (13,'J. Michael Straczynski'),
 (14,' Akira Toriyama'),
 (15,' Ryo Suzukaze'),
 (16,'Sui Ishida'),
 (17,'Bill Willingham'),
 (18,'Ed Greenwood'),
 (19,'Hwei Lim'),
 (20,'Étienne Davodeau '),
 (21,'Giancarlo Berardi'),
 (22,'Ivan Brandon'),
 (23,'Zidrou');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;


--
-- Definition of table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `cod_categoria` int(5) NOT NULL,
  `nom_categoria` varchar(30) NOT NULL,
  PRIMARY KEY (`cod_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`cod_categoria`,`nom_categoria`) VALUES 
 (1,'Series'),
 (2,'Novela gráfica'),
 (3,'DC Comics'),
 (4,'Marvel comics'),
 (5,'Manga'),
 (6,'Fantástico');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


--
-- Definition of table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id_comment` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `isbn` varchar(45) NOT NULL,
  `dni_user` varchar(45) NOT NULL,
  `comentario` varchar(1000) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `FK_comments_1` (`isbn`),
  KEY `FK_comments_2` (`dni_user`),
  CONSTRAINT `FK_comments_1` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`),
  CONSTRAINT `FK_comments_2` FOREIGN KEY (`dni_user`) REFERENCES `user` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`id_comment`,`isbn`,`dni_user`,`comentario`,`fecha`) VALUES 
 (1,'9788468478500','32658945W','Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni','2017-07-20 00:00:00'),
 (2,'9788468478500','78787878F','Tiene algún altibajo pero merece la pena al 100% porque es algo completamente diferente y que, pese a lo absurdo que resulta, consigue un gran equilibrio y calidad.\r\nLo de que van a hacer serie de televisión sobre esta serie me resulta un poco difícil de verla bien producida.','2017-08-01 00:00:00'),
 (3,'9788491670513','78787878F','No es una mala opción para pasar una tarde leyendo algo, eso sí, cualquier otra obra de éstos dos es mejor... ','2017-08-01 15:23:00'),
 (8,'9788416400720','78787878F','Que pena que no haya mas comic tan sencillos y profundos como este... su autor es experto en reportajes reales... al igual que lo hace en Los Ignorantes... me ha encantado. Transmite amor por el campo, la agricultura ecologica y la gente sencilla que nos da de comer. Como ingeniera agronoma que soy solo puedo valorarlo aún más. Lo recomendaré como lectura entre mi alumnado...y tambien lo recomiendo a quienes no se conforman con las decisiones que nos llegan dadas por los poderosos.','2017-08-04 11:42:32'),
 (31,'9788467926712','32658945W','Resulta tan enriquecedor poder leer, y conocer, pequeñas historias como esta, que en realidad demuestran no ser tan pequeñas y sí enormemente necesarias. Una bella historia-reportaje contada con gran maestría.','2017-09-06 21:08:54'),
 (32,'9788417147921','32658945W','Nuevamente, es una edición increíble. Tapa dura con sobrecubierta, todo a color, ilustraciones recopilatorias y bocetos adicionales. Este número trae, además, el extra de 1001 noches de nieve.\r\nTodo perfecto y precioso, genial para los fans de Fábulas.','2017-02-21 13:24:12'),
 (33,'9788467926712','32658945W','Pues eso, gran parte del conocimiento de Morrison como buen mago del caos, simbolismos, sígiles, cábala, universos paralelos, pesadillas, monstruos... a mi personalmente me ha gustado mucho, de hehco me atrapó como hacía tiempo no me atrapaba una historia. Eso sí, hay que saber un poco de la obra de Grant Morrison y lo que maneja.\r\nAl final salen bocetos, detalles y la obra en sí comentada por Morrison, con sus influencias y significados más enrrevesados para poder entenderlo mejor todo el conjunto, por si se nos escapa algo.','2017-03-16 19:26:09'),
 (34,'9788467927856','32658945W','Me parece ,como los otros extras,de lectura y vision obligatoria para conocer y entender un poco mas el mundo y personajes de Attack on titan ,obligatorio para fans de la saga.','2016-09-26 05:56:08'),
 (35,'9788417176198','78787878F','En Italia, Mondadori ha editado los primeros 6 números en dos tomos a color, pero la han parado...\r\nBuena noticia la de esta edición. Y esto abre la puerta a otros grandes fumetti italianos, bonellis incluidos, que los pueda publicar ECC','2017-08-02 13:00:56'),
 (36,'9788467927627','78787878F','Muy contento con la entrega, realizé ayer el pedido y me ha llegado esta mañana. La única pega es que me esperaba el formato de esta edición más grande (17x12 cm) aprox. En general satisfecho con la compra y con ganas de empezar a leerlo.','2017-05-18 21:32:03'),
 (37,'9788491460886','35773915Z','La verdad que pille toda la serie de promoción y me los estoy leyendo poco a poco. Lo cierto es que son un poco cortos pero las ilustraciones están muy curradas. Además, si tienes el videojuego como es mi caso pues siempre entiendes mejor la historia. Desde luego que, recomiendo su lectura, es rápida y entretenida.','2017-03-21 13:06:54'),
 (38,'9788416880256','35773915Z','Genial obra con un aprovado justo en la edición, pues los diálogos y algunas viñetas se aprecia pixelado. Por el precio está más que aceptable.','2017-07-23 22:05:34'),
 (39,'9788416880256','35773915Z','Esta historia con guion y dibujo de Hwei Lim es de un preciosismo brutal. Cada uno de los cinco capítulos utiliza una gama de colores específica que nos permite evolucionar con el protagonista, partiendo de un monocromo atropellado al más vistoso colorismo. El autor juega con una gran variedad de técnicas narrativas en la forma y dinámica de las viñetas, consiguiendo crear el ritmo adecuado en cada momento: desde una asfixiante jornada de running hasta el éxtasis visual de los planos cenitales. El truco es una historia intimista a ratos silenciosa en la que más de uno se reconocerá sin titubeos','2017-05-13 18:25:42'),
 (40,'9788415844341','35773915Z','Un cómic de culto, con más de 20 años a la espalda y con una película que tiene poco que ver de 2001, con Steve Buscemi y Scarlett Johansson. Cuenta el día a día de dos amigas, recién terminado el instituto. No son niñas, pero tampoco se puede decir que sean mujeres maduras y preparadas para vivir lo que se les viene encima. Costumbrismo americano. Interesante.','2017-01-31 19:16:34'),
 (41,'9788491670063','35773915Z','una historia apasionante con buen guion y buenos trazos, una gran crompra sin duda, para los amantes del comic marvel','2017-07-23 23:05:41');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;


--
-- Definition of table `compra`
--

DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `id_compra` int(8) NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) NOT NULL,
  `fecha_compra` date NOT NULL,
  `precio_final` double(5,2) NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `fk_compra_cliente` (`dni`),
  CONSTRAINT `fk_compra_cliente` FOREIGN KEY (`dni`) REFERENCES `user` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compra`
--

/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;


--
-- Definition of table `detalles_compra`
--

DROP TABLE IF EXISTS `detalles_compra`;
CREATE TABLE `detalles_compra` (
  `id_compra` int(8) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(13) NOT NULL,
  `cantidad` int(3) NOT NULL,
  PRIMARY KEY (`id_compra`,`isbn`),
  KEY `fk_detalles_compra_libro` (`isbn`),
  CONSTRAINT `fk_detalles_compra_compra` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `fk_detalles_compra_libro` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detalles_compra`
--

/*!40000 ALTER TABLE `detalles_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalles_compra` ENABLE KEYS */;


--
-- Definition of table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
CREATE TABLE `editorial` (
  `cod_editorial` int(5) NOT NULL,
  `nom_editorial` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_editorial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `editorial`
--

/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
INSERT INTO `editorial` (`cod_editorial`,`nom_editorial`) VALUES 
 (1,'Planeta comic'),
 (2,'Ecc'),
 (3,'Norma'),
 (4,'Panini'),
 (5,'Image comics'),
 (6,'Vértigo'),
 (7,'Astiberri'),
 (8,'La cúpula');
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;


--
-- Definition of table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites` (
  `id_fav` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `isbn` varchar(13) NOT NULL,
  `dni` varchar(9) NOT NULL,
  PRIMARY KEY (`id_fav`),
  KEY `FK_favorites_1` (`isbn`),
  KEY `FK_favorites_2` (`dni`),
  CONSTRAINT `FK_favorites_1` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`),
  CONSTRAINT `FK_favorites_2` FOREIGN KEY (`dni`) REFERENCES `user` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `favorites`
--

/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` (`id_fav`,`isbn`,`dni`) VALUES 
 (1,'9788468478500','32658945W'),
 (2,'9788491460886','35773915Z'),
 (3,'9788416796229','78787878F'),
 (4,'9788415844341','32658945W'),
 (5,'9788467926712','78787878F'),
 (6,'9788417176303','35773915Z'),
 (7,'9788491670063','78787878F'),
 (8,'9788491670520','32658945W'),
 (9,'9788491670513','35773915Z'),
 (10,'9788491670506','32658945W'),
 (11,'9788491670094','78787878F'),
 (12,'9788445002353','35773915Z'),
 (13,'9781582406121','78787878F'),
 (14,'9788498851649','35773915Z'),
 (15,'9788490241882','32658945W'),
 (16,'9788490249406','78787878F'),
 (17,'9788417176532','35773915Z'),
 (18,'9788416889815','35773915Z'),
 (19,'9788467927856','78787878F'),
 (20,'9788467928136','35773915Z'),
 (21,'9788467925364','32658945W');
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;


--
-- Definition of table `libro`
--

DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `isbn` varchar(13) NOT NULL,
  `titulo` varchar(60) NOT NULL,
  `cod_autor` int(5) NOT NULL,
  `cod_categoria` int(5) NOT NULL,
  `cod_editorial` int(5) NOT NULL,
  `precio` double(5,2) NOT NULL,
  `stock` int(4) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `imagen` varchar(45) NOT NULL,
  `oferta` int(1) NOT NULL DEFAULT '0',
  `fecha_publicacion` date NOT NULL,
  PRIMARY KEY (`isbn`),
  KEY `fk_libro_autor` (`cod_autor`),
  KEY `fk_libro_editorial` (`cod_editorial`),
  KEY `fk_libro_categoria` (`cod_categoria`),
  CONSTRAINT `fk_libro_autor` FOREIGN KEY (`cod_autor`) REFERENCES `autor` (`cod_autor`),
  CONSTRAINT `fk_libro_categoria` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`cod_categoria`),
  CONSTRAINT `fk_libro_editorial` FOREIGN KEY (`cod_editorial`) REFERENCES `editorial` (`cod_editorial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `libro`
--

/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` (`isbn`,`titulo`,`cod_autor`,`cod_categoria`,`cod_editorial`,`precio`,`stock`,`descripcion`,`imagen`,`oferta`,`fecha_publicacion`) VALUES 
 ('9781582406121','Walking dead 5. The best defense',11,2,5,11.20,36,'Walking dead 5. The best defense. As the survivors settle into their prison home something has drawn them out into the open... out of the prison... out of their sanctuary. This is a major turning point for the overall story of The Walking Dead, setting the stage for years to come.','walkingdead.png',0,'2017-07-21'),
 ('9788415844341','¡Batman y Robin deben morir!',4,3,2,16.20,9,'En los albores del regreso de Bruce Wayne, Simon Hurt y el Profesor Pyg amenazan con convertir Gotham City en la nueva capital del crimen. Un maquiavélico plan que deberán desbaratar Batman y Robin, todavía consternados por la revelación de que bajo la máscara de Oberon Sexton se ocultaba en realidad... el mismísimo Joker. Grant Morrison aborda un punto de inflexión en su ambiciosa etapa al frente de las aventuras del Hombre Murciélago, acompañado de un impresionante elenco de dibujantes –Frazer Irving, Cameron Stewart, Chris Burnham, Tony Daniel, Frank Quitely, Scott Kolins, Andy Kubert y David Finch– puesto al servicio de una historia tan sorprendente como épica','batman.png',1,'2017-05-29'),
 ('9788416400720','rural',20,2,8,13.78,51,'Ésta es la historia de una tranquila zona rural. Tras diez años de trabajo, una pareja ha convertido unas viejas ruinas en una casa preciosa. Un poco más lejos, tres jóvenes campesinos, convencidos de que otro tipo de agricultura es posible, apuestan por lo bio. Es un lugar realmente hermoso y apacible hasta el día en que reciben la noticia: una autopista va a pasar por allí. Antes de la gran acogida de crítica y público obtenida por Los ignorantes, Étienne Davodeau se imponía con esta obra como un maestro —y un pionero— del cómic reportaje. Tras un año de intensa observación lápiz en mano sobre el terreno, hizo de esta historia verdadera una verdadera historia, tan cautivadora como una de ficción. Un narrador excepcional.','rural.png',0,'2017-04-03'),
 ('9788416796229','Batman: Detective Parte 2',3,3,2,12.34,16,'En Gotham City, el crimen, la violencia y la corrupción siempre han estado a la orden del día. Pero hay una persona que desafía toda esa oscuridad: Batman. Haciendo honor a su título de mejor detective del mundo, el Caballero Oscuro se enfrenta a viejos enemigos, como el Joker, pero también a alguno nuevo, como Vox. Incluso se alía con Zatanna para atrapar a un mago malvado que recorre las calles. El Cruzado de la Capa no se detendrá ante nada para proteger su ciudad. ','batman2.png',0,'2017-06-13'),
 ('9788416880256','Mirror 1 El reflejo de la montaña',19,5,7,18.05,15,'Tras Bella Muerte e I.D., Emma Ríos vuelve con una historia sobre la identidad, la aceptación y la libertad de elegir. Un misterioso asteroide acoge una selección de extrañas criaturas –híbridos entre humanos y ani-males, seres mitológicos, espíritus guardianes y sombras malditas– y los humanos que les dieron vida. Esta insólita sociedad vive en una frágil tre-gua, tras un levantamiento en busca de libertad y aprobación que terminó en tragedia. Emma Ríos (Bella Muerte, I.D.) y Hwei Lim (Hero) presentan Mirror. El reflejo de la montaña, primera entrega de su serie sobre los alquimistas de la Sincronía y los animales conscientes de la colonia de Irzah, que explora el concepto de humanidad. Parcialmente inspirada en Oda a Kirihito, de Osamu Tezuka, y La isla del Dr. Moreau, de H. G. Wells, Mirror es una historia sobre la identidad, la aceptación y la libertad de elegir.','mirror.png',1,'2017-07-19'),
 ('9788416889815','Dragon ball serie roja 216',14,5,6,2.80,23,'Sigue la edición nostálgica de la nueva etapa de Dragon Ball por Toyotaro. Han pasado unos meses desde la trepidante batalla de Goku y los suyos contra el monstruo Bû. Y, ahora entra en liza un poderosísimo ser... ¡Un dios, nada menos!','dragonball.png',0,'2017-07-02'),
 ('9788417147921','Fábulas: Edición de lujo - Libro 13',17,6,6,31.80,8,'Este decimotercer tomo de Fábulas: Edición de lujo incluye la desgarradora historia del paso a la edad adulta Cachorros en la Tierra de los Juguetes, así como los demoledores acontecimientos de Una revolución en Oz y Blanca Nieves, correspondientes a los números del 114 al 129 de la premiada serie de Vertigo. Incluye una nueva introducción de Lauren Beukes, la aclamada autora de The Shining Girls y Broken Monsters, así como una sección especial de bocetos del dibujante Mark Buckingham.','fabulas.png',0,'2017-02-13'),
 ('9788417176198','Ken Parker 1: Largo fusil/Mine Town',21,1,2,9.45,18,'Montana, 1868. Ken Parker es un trampero que recorre el espinazo de Las Rocosas en compañía de su hermano menor. Es un vagabundo, un soñador, un cazador que detesta matar incluso cuando matar es necesario. Pero su vida da un vuelco el día en que unos forajidos lo asaltan, le roban y asesinan a su hermano. A partir de entonces emprende un viaje en busca de venganza que tal vez lo lleve demasiado lejos. Creada por dos referentes del cómic europeo de la talla de Giancarlo Berardi e Ivo Milazzo, Ken Parker es todo un clásico del noveno arte. Una brillante incursión en el western que a lo largo de los años ha deparado historias para el recuerdo, ahora recuperadas a través de una nueva edición. El presente volumen recopila Largo Fusil y Mine Town, aventuras que sirvieron de carta de presentación de un personaje inolvidable. ','kenparker.png',0,'2017-04-19'),
 ('9788417176303','Especial Flash Comics (1940-2015): 75 años de Flash',4,3,2,14.73,12,'Flash está más de actualidad que nunca, cosechando éxito gracias a la serie de televisión, protagonizada por Grant Gustin, y con el actor Ezra Miller (Las ventajas de ser un marginado), confirmado como el Velocista Escarlata cinematográfico en Liga de la Justicia (Zack Snyder, 2017) y en su propia película en solitario (2018). Además, está totalmente consagrado como parte esencial del Universo DC, tanto por su aportación a la Liga de la Justicia como por Flash, su serie regular que relata cada mes aventuras encuadradas en la actual gran etapa de DC Entertainment, Renacimiento.','flash.png',1,'2017-08-03'),
 ('9788417176532','Antes de Watchmen: Búho Nocturno',13,3,2,14.20,8,'En los años sesenta, Dan Dreiberg era un adolescente con muchos problemas que idolatraba a su mayor héroe: el Búho Nocturno original, Hollis Mason. Tanto que llegaría a heredar el título del veterano justiciero e incluso conocería a otros enmascarados, como Rorschach y Lady Crepúsculo, en un pasado que Moore y Gibbons apenas insinuaron y que aquí se revela decisivo para la forja de la personalidad del protagonista.','watchmen.png',1,'2017-08-03'),
 ('9788445002353','The Walking Dead: La caída del Gobernador',11,2,5,11.20,14,'Llega el último libro de la serie, donde convergen los argumentos de las tres primeras novelas, las tensiones avanzan hacia un caos inimaginable y los destinos de los pocos supervivientes del apocalipsis zombie quedan sellados en una sucesión de giros sorprendentes. Los personajes de la serie y el cómic, como Rick y Michonne, vuelven a aparecer para plantarle cara al Gobernador, y Rick debe enfrentarse a él por última vez a sabiendas de que sólo uno de ellos sobrevivirá?','walkingdead2.png',0,'2017-05-11'),
 ('9788467912838','Dungeons & dragons. Reinos Olvidados',18,6,3,15.20,9,'Randral y Torn “Ojo de acero” son unos especialistas del trapicheo malviviendo en la ciudad de Aguas Profundas y esta noche parece que la fortuna les acompaña. ¿O será más bien la mala suerte? Cuando se crucen con una banda raptando a la noble Talandra Cuerno Rugiente , dará comienzo una trepidante persecución en la que malhechores y criaturas de toda calaña participarán para obtener un buen botín. Ed Greenwood , el creador de los Reinos Olvidados , nos presenta una aventura situada en este interesante mundo ilustrado por Lee Ferguson.','dungeons.png',0,'2017-07-17'),
 ('9788467925364','Tokyo Ghoul Re 8',16,5,3,7.60,13,'En la prisión de Cochlea resuenan las alarmas: ¡los ghouls de las celdas van siendo liberados! El \"último trabajo\" de Haise Sasaki se aproxima a su fin con la aparición de Kisho Arima. ¿Cómo terminará todo…?','tokyo.png',0,'2017-01-23'),
 ('9788467926712','Nameless: Sin nombre',5,2,3,20.90,4,'Un astrónomo mata a su familia y después se suicida, dejando una advertencia críptica. Una dama ataviada con un velo caza a sus víctimas a través de las pesadillas humanas. Un buscavidas ocultista, conocido únicamente como Sin Nombre, es reclutado por un consorcio de multimillonarios futuristas para llevar a cabo una misión desesperada. Y el malévolo asteroide Xibalbase acerca a la Tierra en rumbo de colisión. Pero nada es lo que parece, sino que un aterrador experimento inhumano está a punto de comenzar. ¡Abandonad toda esperanza y experimentad el horror definitivo!','nameless.png',0,'2017-05-02'),
 ('9788467927627','Drifter 3 iluminado por el fuego',22,1,3,15.68,36,'Tras regresar de su peligrosa expedición, Abram Pollux se encuentra la colonia ocupada por amenazantes rondadores. Su deseo de venganza va en aumento y el miedo en los colonos está a punto de provocar una guerra abierta con los misteriosos alienígenas. Ivan Brandon y Nic Klein aumentan la tensión en esta magnífica obra de ciencia ficción que no dejará a nadie indiferente ','drifter.png',0,'2017-07-08'),
 ('9788467927795','Marina 3: Razzias',23,1,3,15.20,23,'Aunque han pasado más de setecientos años, los gondoleros de Venecia todavía cantan a día de hoy la Canzone di Marina. Habla de Marina, la hija del Dux de Venecia que terminó sus días como pirata. Habla de la terrible maldición que pesa sobre la ciudad de los canales. Habla del fin inminente y definitivo de un lugar que puso sus cimientos tanto en la madera de los pilotes como sobre sus propias leyendas.Tercera entrega de la saga de la pirata veneciana ideada por Zidrou (Lydie, La piel del oso) y Matteo (Vampiros: Sable Noir). La maldición de Marina está en marcha... y Venecia tiembla ','marina.png',0,'2017-06-13'),
 ('9788467927856','Ataque a los titanes 2: Lost girls',15,5,3,7.60,19,'En la segunda parte de esta miniserie centrada en los personajes femeninos de Ataque a los titanes, nos trasladamos al momento en el que el espíritu de Mikasa regresa a la vida cálida y tranquila en el bosque y al encuentro con el niño que cambió su mundo. Esta es la historia de la ilusión que forjó un fuerte vínculo entre Eren y Mikasa cuando tenían nueve años. ','titanes2.png',0,'2017-05-30'),
 ('9788467928136','Ataque a los titanes 3: Antes de la caída',15,5,3,7.60,23,'Carla espera en el taller de Zenophon a Kyklo, que ha ido a Shiganshina a probar sobre el terreno el nuevo modelo del dispositivo. Sin embargo, llega el día previsto para su vuelta y él no aparece. Mientras tanto, en la Ciudad Industrial, la Organización Antisistema está elaborando en secreto un plan para sublevarse… y entre sus miembros está Xavi, de la policía militar, que se ha infiltrado para cumplir una misión.','titanes.png',1,'2017-06-05'),
 ('9788468478500','Chew 12',1,1,1,17.05,3,'Este es el arco argumental final de Tony Chu, el agente federal cibópata con la habilidad de recibir impresiones psíquicas de todo lo que come. Se resuelven misterios, se revelan secretos y se pierden vidas. Muchas, muchas vidas. Este es el final de uno de los mayores éxitos de ventas según el New York Times, de la serie ganadora del premio Harvey y de múltiples premios Eisner que trata sobre polis, criminales, cocineros, caníbales y clarividentes.','chew.png',0,'2017-04-20'),
 ('9788490241882','kick2',12,2,4,18.95,21,' Llega la secuela del fenómeno mundial que se atrevió a preguntarse qué ocurriría si los superhéroes existieran en el mundo real... ¡Tienes que leer el cómic antes de que se convierta en una nueva superproducción cinematográfica! Mark Millar y John Romita Jr. retoman la historia allá donde la dejaron en el primer volumen. Hit Girl ha vuelto para entrenar a Kick-Ass y convertirle en el más amenazador y terrible justiciero de la ciudad. Mientras tanto, su gran enemigo, Red Mist, ha reunido a su propio equipo de supervillanos: ¡La más sucia y sangrienta batalla callejera ha comenzado a prepararse!','kick2.png',0,'2017-07-16'),
 ('9788490249406','kick3',12,2,4,18.95,12,' ¡El gran final de la superproducción de Millar y Romita Jr.! Hit-Girl está en prisión y ahora Kick-Ass tendrá que liderar todo un grupo de superhéroes. Pero ahora los justicieros disfrazados están fuera de la ley, dejando a nuestro protagonista a merced de la policía y de sus nuevos enemigos. Por primera vez, Dave ha empezado a dudar. ¿Está demasiado metido en esto como para dejarlo? Con este tomo, Kick-Ass llega a una épica conclusión. ¿Estás dispuesto a perdértelo? Autores: Mark Millar y John Romita jr.','kick3.png',0,'2017-06-14'),
 ('9788491460886','Ladrón de ladrones 6',2,2,1,15.16,31,'Ladrón de ladrones cuenta la historia de Conrad Paulson, el mejor ladrón de guante blanco del mundo.','ladron.png',0,'2017-07-20'),
 ('9788491670063','Los Vengadores Vs la Patrulla X. Segunda parte',6,4,4,22.75,9,'La conclusión del evento que cambió la faz del Universo Marvel. La Fuerza Fénix ha llegado a la Tierra y se ha hecho carne: todo cambia. La guerra de La Patrulla-X contra Los Vengadores da un giro inesperado y se extiende hasta el último confín. ¿Qué ocurrirá además cuando La Bruja Escarlata y Hope unan fuerzas?','avengers.png',1,'2017-07-25'),
 ('9788491670094','Viuda Negra 2 No más secretos',10,4,4,14.25,19,' La Habitación Roja, el lugar en que Natasha Romanov fue transformada en una máquina de matar, ha vuelto a abrirse, más peligrosa que nunca. La Viuda Negra planea su total destrucción, pero antes tendrá que enfrentarse a la hija de su directora, quien está decidida a probar su valía asesinando a Natasha. Autores: Mark Waid y Chris Samnee','viudanegra.png',0,'2017-06-24'),
 ('9788491670506','Una gata imparable',9,4,4,13.30,5,'Cruce con “Civil War II”. En otro mundo, podrían haber sido amigas de las que se ayudan en los momentos difíciles, pero cuando Patsy Walker y Jessica Jones se conozcan en el Universo Marvel podrían llegar a saltar chispas.','gatainfernal.png',0,'2017-04-23'),
 ('9788491670513','Hulk: Gris',8,4,4,15.68,28,'En la tradición de sus éxitos Spiderman: Azul y Daredevil: Amarillo, Jeph Loeb y Tim Sale presentan el siguiente de sus acercamientos nostálgicos a los orígenes de los personajes Marvel. Esta vez, el viaje en el tiempo nos lleva hasta los primeros días de existencia de Hulk, cuando el color de su piel todavía no había pasado a ser verde y tan sólo Rick Jones conocía la terrible verdad acerca del Monstruo Gamma.','hulk.png',0,'2017-07-21'),
 ('9788491670520','El Asombroso Spiderman 16 La primera cacería de Kraven',4,4,4,18.53,9,'Su apellido es terriblemente familiar. Y acaba de descubrir la identidad secreta de Spiderman. El trepamuros se enfrenta a la heredera del imperio de Sergei Kravinoff. Además, la presentación de la villana más original que hayas visto nunca, Muñeca de papel, y el regreso de Amenaza','spiderman.png',1,'2017-02-24'),
 ('9788498851649','kick1',12,2,4,18.95,9,'¡Antes de ver la película, no puedes dejar de leer el cómic! Al fin está aquí el mayor superhéroe de todos los tiempos. Mark Millar (Ultimates) y John Romita Jr. (Asombroso Spiderman) se reúnen de nuevo para realizar el más ambicioso cómic del nuevo siglo. ¿Alguna vez has querido ser un superhéroe? ¿Soñabas con ponerte una máscara y salir ahí fuera a pegar una paliza a los malos? Bueno, pues este cómic es para ti. ¡El cómic que empieza allá donde otros sólo se atreven a llegar! Si te lo pierdes, debes ser idiota.','kick1.png',1,'2017-03-16');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido1` varchar(30) NOT NULL,
  `apellido2` varchar(30) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `user` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `imagen` varchar(30) NOT NULL DEFAULT 'default-profile.png',
  `privilegios` int(1) NOT NULL DEFAULT '0',
  `ultima_conexion` date NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `user` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`dni`,`nombre`,`apellido1`,`apellido2`,`direccion`,`fecha_nacimiento`,`email`,`user`,`password`,`imagen`,`privilegios`,`ultima_conexion`) VALUES
 ('32658945W','jon','Acedo','Bilbao','Calle del palomino 15','2016/07/19','ionacedo@gmail.com','jonacedo','wen1wen2', 'default-profile.png', 1, '2017/08/04'),
 ('35773915Z','Ruth','Llorens','Tolosa','Mi casa','2017/04/20','rllorens@serikat.es','ruth1','ruth', 'ruth.png', 0, '2017/08/05' ),
 ('78787878F','mj','izu','rodri','PASEO DDD','2017/01/01','M@GMAIL.COM','usu','usu', 'usu.png', 1, '2017/08/05');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;