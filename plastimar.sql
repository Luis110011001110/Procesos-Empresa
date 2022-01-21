-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2019 a las 05:04:53
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.2.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `plastimar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `id_almacen` int(11) NOT NULL,
  `nombre_almacen` varchar(100) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`id_almacen`, `nombre_almacen`, `descripcion`) VALUES
(2, 'almacen1', '223');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nombre_categoria` varchar(100) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nombre_categoria`, `descripcion`) VALUES
(1, 'Plasticos', '2112'),
(2, 'botellas', 'botellitas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido_paterno` varchar(30) NOT NULL,
  `apellido_materno` varchar(30) NOT NULL,
  `correo_contacto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ctrl_productossucursal`
--

CREATE TABLE `ctrl_productossucursal` (
  `id_productosucursal` int(11) NOT NULL,
  `id_sucursal` int(11) NOT NULL,
  `id_almacen` int(11) NOT NULL,
  `id_productos` int(11) NOT NULL,
  `stok_producto` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ctrl_productossucursal`
--

INSERT INTO `ctrl_productossucursal` (`id_productosucursal`, `id_sucursal`, `id_almacen`, `id_productos`, `stok_producto`) VALUES
(1, 5, 2, 4, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` int(11) NOT NULL,
  `id_sucursal` int(11) NOT NULL,
  `id_tipousuario` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido_paterno` varchar(30) NOT NULL,
  `apellido_materno` varchar(30) NOT NULL,
  `sexo` char(1) NOT NULL DEFAULT 'I',
  `fecha_nacimiento` date NOT NULL,
  `curp` varchar(18) NOT NULL,
  `telefono_contacto` varchar(100) DEFAULT NULL,
  `correo` varchar(100) NOT NULL,
  `password` varchar(300) NOT NULL,
  `fecha_alta` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `id_sucursal`, `id_tipousuario`, `nombre`, `apellido_paterno`, `apellido_materno`, `sexo`, `fecha_nacimiento`, `curp`, `telefono_contacto`, `correo`, `password`, `fecha_alta`) VALUES
(1, 4, 1, 'Jorge', 'Parra', 'Alvarado', 'h', '2019-11-14', 'kjlsafndjewndlñakj', '7289387129', 'parra', 'parra123', '2019-11-20 23:16:08'),
(2, 5, 3, 'guz', 'gonza', 'ruiz', 'h', '2019-11-20', 'jsdkhdnskjaop', '7220219038', 'guz', 'guz123', '2019-11-20 23:16:08'),
(3, 4, 2, 'raull', 'gonzalezz', 'martinezz', 'H', '2019-11-08', 'okpdjsnldsfnn', '72298123779', 'raull', 'raull123', '2019-11-20 23:17:08'),
(4, 4, 1, 'mosh', 'fernan', 'gonza', 'H', '2019-01-01', 'mosh123jkadns', '87218912', 'correomosh', 'mosh123', '2019-11-21 06:00:00'),
(5, 8, 2, 'eliass', 'ciprianoo', 'gonzaa', 'M', '2019-11-08', 'lkajsdnklsdm', '87962432', 'eliass', 'elias123', '2019-11-08 06:00:00'),
(6, 8, 3, 'jesus', 'martinez', 'gonzalez', 'H', '2005-11-10', 'curp123', '12879987', 'jesus', 'martinez', '2019-11-27 06:00:00'),
(7, 8, 2, 'mario bros', 'gonzalezz', 'huertaa', 'H', '2019-11-15', 'klasjdklndsaa', '73781297', 'mario1', 'mario123', '2019-11-27 06:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `id_empresa` int(11) NOT NULL,
  `nombre_empresa` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `mision` varchar(500) NOT NULL,
  `vision` varchar(500) NOT NULL,
  `ubicacion` varchar(250) NOT NULL,
  `web` varchar(300) DEFAULT NULL,
  `rfc` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `id_estado` int(11) NOT NULL,
  `nombre_estado` varchar(30) NOT NULL,
  `capital` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`id_estado`, `nombre_estado`, `capital`) VALUES
(1, 'Aguascalientes', 'Aguascalientes'),
(2, 'Baja California', 'Mexicali'),
(3, 'Baja California Sur', 'La paz'),
(4, 'Campeche', 'Campeche'),
(5, 'Coahuila', 'Saltillo'),
(6, 'Colima', 'Colima'),
(7, 'Chiapas', 'Tuxtla Gutiérrez'),
(8, 'Chihuahua', 'Chihuahua'),
(9, 'Distrito Federal', 'Ciudad de México'),
(10, 'Durango', 'Durango'),
(11, 'Guanajuato', 'Guanajuato'),
(12, 'Guerrero', 'Chilpancingo'),
(13, 'Hidalgo', 'Pachuca'),
(14, 'Jalisco', 'Guadalajara'),
(15, 'México', 'Toluca'),
(16, 'Michoacán', 'Morelia'),
(17, 'Morelos', 'Cuernavaca'),
(18, 'Nayarit', 'Tepic'),
(19, 'Nuevo León', 'Monterrey'),
(20, 'Oaxaca', 'Oaxaca'),
(21, 'Puebla', 'Puebla'),
(22, 'Querétaro', 'Querétaro'),
(23, 'Quintana Roo', 'Chetumal'),
(24, 'San Luis Potosí', 'San Luis Potosí'),
(25, 'Sinaloa', 'Culiacán'),
(26, 'Sonora', 'Hermosillo'),
(27, 'Tabasco', 'Villahermosa'),
(28, 'Tamaulipas', 'Ciudad Victoria'),
(29, 'Tlaxcala', 'Tlaxcala'),
(30, 'Veracruz', 'Xalapa'),
(31, 'Yucatán', 'Mérida'),
(32, 'Zacatecas', 'Zacatecas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos_sucursal`
--

CREATE TABLE `pedidos_sucursal` (
  `id_pedidosucursal` int(11) NOT NULL,
  `id_sucursal` int(11) NOT NULL,
  `id_productos` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_solicitud` int(11) NOT NULL,
  `cantidad_solicitada` int(11) NOT NULL,
  `estado_pedido` varchar(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_proveedor`
--

CREATE TABLE `pedido_proveedor` (
  `id_pedidoproveedor` int(11) NOT NULL,
  `id_sucursal` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_productos` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_solicitud` int(11) NOT NULL,
  `cantidad_solicitada` int(11) NOT NULL,
  `precio_unitario` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_productos` int(11) NOT NULL,
  `nombre_producto` varchar(100) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `precio_fabricacion` float NOT NULL,
  `precio_venta` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_productos`, `nombre_producto`, `id_categoria`, `descripcion`, `precio_fabricacion`, `precio_venta`) VALUES
(1, 'Envase', 1, 'Envase de 600ml', 5, 10.5),
(4, 'vass', 2, 'vasitoo', 10, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nombre_proveedor` varchar(100) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `web` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE `solicitud` (
  `id_solicitud` int(11) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `fecha_recibido` date DEFAULT NULL,
  `descripcion_solicitud` varchar(300) NOT NULL,
  `descripcion_respuesta` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `id_sucursal` int(11) NOT NULL,
  `nombre_sucursal` varchar(40) NOT NULL,
  `tipo` int(11) NOT NULL,
  `estado` int(3) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `telefono` int(11) NOT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`id_sucursal`, `nombre_sucursal`, `tipo`, `estado`, `direccion`, `telefono`, `correo`) VALUES
(4, 'plastimar', 1, 1, 'toluca', 712398324, 'correoplastimar'),
(5, 'plastimar2', 2, 2, 'guana', 722289127, 'correoplastimar2'),
(8, 'botellas', 2, 12, 'gerr', 29234, 'correobotellas'),
(9, 'tapas', 1, 7, 'chihuahua', 12387, '12387');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_sucursal`
--

CREATE TABLE `tipo_sucursal` (
  `id_tiposucursal` int(11) NOT NULL,
  `tipo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_sucursal`
--

INSERT INTO `tipo_sucursal` (`id_tiposucursal`, `tipo`) VALUES
(1, 'Primaria'),
(2, 'Secundaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id_tipousuario` int(11) NOT NULL,
  `tipo_usuario` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_tipousuario`, `tipo_usuario`) VALUES
(1, 'Administrador'),
(2, 'Gerente'),
(3, 'Empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `id_sucursal` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `cantidad_vendida` int(11) NOT NULL DEFAULT 1,
  `fecha_venta` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_productos`
--

CREATE TABLE `venta_productos` (
  `id_ventaproductos` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `id_productosucursal` int(11) NOT NULL,
  `cantidad_vendida` int(11) NOT NULL DEFAULT 1,
  `descripcion` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id_almacen`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `correo_contacto` (`correo_contacto`);

--
-- Indices de la tabla `ctrl_productossucursal`
--
ALTER TABLE `ctrl_productossucursal`
  ADD PRIMARY KEY (`id_productosucursal`),
  ADD KEY `id_sucursal` (`id_sucursal`),
  ADD KEY `id_almacen` (`id_almacen`),
  ADD KEY `id_productos` (`id_productos`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`),
  ADD UNIQUE KEY `curp` (`curp`),
  ADD UNIQUE KEY `correo` (`correo`),
  ADD KEY `id_tipousuario` (`id_tipousuario`),
  ADD KEY `id_sucursal` (`id_sucursal`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id_empresa`),
  ADD UNIQUE KEY `rfc` (`rfc`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `pedidos_sucursal`
--
ALTER TABLE `pedidos_sucursal`
  ADD PRIMARY KEY (`id_pedidosucursal`),
  ADD KEY `id_sucursal` (`id_sucursal`),
  ADD KEY `id_productos` (`id_productos`),
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_solicitud` (`id_solicitud`);

--
-- Indices de la tabla `pedido_proveedor`
--
ALTER TABLE `pedido_proveedor`
  ADD PRIMARY KEY (`id_pedidoproveedor`),
  ADD KEY `id_sucursal` (`id_sucursal`),
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_productos` (`id_productos`),
  ADD KEY `id_proveedor` (`id_proveedor`),
  ADD KEY `id_solicitud` (`id_solicitud`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_productos`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedor`),
  ADD UNIQUE KEY `telefono` (`telefono`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD PRIMARY KEY (`id_solicitud`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`id_sucursal`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `tipo_sucursal`
--
ALTER TABLE `tipo_sucursal`
  ADD PRIMARY KEY (`id_tiposucursal`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_tipousuario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_sucursal` (`id_sucursal`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `venta_productos`
--
ALTER TABLE `venta_productos`
  ADD PRIMARY KEY (`id_ventaproductos`),
  ADD KEY `id_venta` (`id_venta`),
  ADD KEY `id_productosucursal` (`id_productosucursal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `id_almacen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ctrl_productossucursal`
--
ALTER TABLE `ctrl_productossucursal`
  MODIFY `id_productosucursal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id_empresa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estados`
--
ALTER TABLE `estados`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `pedidos_sucursal`
--
ALTER TABLE `pedidos_sucursal`
  MODIFY `id_pedidosucursal` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido_proveedor`
--
ALTER TABLE `pedido_proveedor`
  MODIFY `id_pedidoproveedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_productos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `solicitud`
--
ALTER TABLE `solicitud`
  MODIFY `id_solicitud` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `id_sucursal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `tipo_sucursal`
--
ALTER TABLE `tipo_sucursal`
  MODIFY `id_tiposucursal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id_tipousuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `venta_productos`
--
ALTER TABLE `venta_productos`
  MODIFY `id_ventaproductos` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ctrl_productossucursal`
--
ALTER TABLE `ctrl_productossucursal`
  ADD CONSTRAINT `ctrl_productossucursal_ibfk_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`),
  ADD CONSTRAINT `ctrl_productossucursal_ibfk_2` FOREIGN KEY (`id_almacen`) REFERENCES `almacen` (`id_almacen`),
  ADD CONSTRAINT `ctrl_productossucursal_ibfk_4` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id_productos`);

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`id_tipousuario`) REFERENCES `tipo_usuario` (`id_tipousuario`),
  ADD CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`);

--
-- Filtros para la tabla `pedidos_sucursal`
--
ALTER TABLE `pedidos_sucursal`
  ADD CONSTRAINT `pedidos_sucursal_ibfk_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`),
  ADD CONSTRAINT `pedidos_sucursal_ibfk_2` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id_productos`),
  ADD CONSTRAINT `pedidos_sucursal_ibfk_3` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  ADD CONSTRAINT `pedidos_sucursal_ibfk_4` FOREIGN KEY (`id_solicitud`) REFERENCES `solicitud` (`id_solicitud`);

--
-- Filtros para la tabla `pedido_proveedor`
--
ALTER TABLE `pedido_proveedor`
  ADD CONSTRAINT `pedido_proveedor_ibfk_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`),
  ADD CONSTRAINT `pedido_proveedor_ibfk_2` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  ADD CONSTRAINT `pedido_proveedor_ibfk_3` FOREIGN KEY (`id_productos`) REFERENCES `productos` (`id_productos`),
  ADD CONSTRAINT `pedido_proveedor_ibfk_4` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`),
  ADD CONSTRAINT `pedido_proveedor_ibfk_5` FOREIGN KEY (`id_solicitud`) REFERENCES `solicitud` (`id_solicitud`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`);

--
-- Filtros para la tabla `venta_productos`
--
ALTER TABLE `venta_productos`
  ADD CONSTRAINT `venta_productos_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`),
  ADD CONSTRAINT `venta_productos_ibfk_2` FOREIGN KEY (`id_productosucursal`) REFERENCES `ctrl_productossucursal` (`id_productosucursal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
