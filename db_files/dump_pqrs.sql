-- MySQL Script generated by MySQL Workbench
-- Fri 28 Apr 2017 17:15:44 COT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tipoSolicitud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tipoSolicitud` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tipoSolicitud` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`filial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`filial` ;

CREATE TABLE IF NOT EXISTS `mydb`.`filial` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`factura` ;

CREATE TABLE IF NOT EXISTS `mydb`.`factura` (
  `id` INT NOT NULL,
  `fechaVenta` DATETIME NOT NULL,
  `filial` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_factura_filial1_idx` (`filial` ASC),
  CONSTRAINT `fk_factura_filial1`
    FOREIGN KEY (`filial`)
    REFERENCES `mydb`.`filial` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipoEmpleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tipoEmpleado` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tipoEmpleado` (
  `id` INT NOT NULL,
  `nombrel` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`empleado` ;

CREATE TABLE IF NOT EXISTS `mydb`.`empleado` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `tipoEmpleado` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_empleado_tipoEmpleado1_idx` (`tipoEmpleado` ASC),
  CONSTRAINT `fk_empleado_tipoEmpleado1`
    FOREIGN KEY (`tipoEmpleado`)
    REFERENCES `mydb`.`tipoEmpleado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`solicitud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`solicitud` ;

CREATE TABLE IF NOT EXISTS `mydb`.`solicitud` (
  `id` INT NOT NULL,
  `fechaCreacion` DATETIME NOT NULL,
  `descripcion` VARCHAR(1000) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `productoServicio` VARCHAR(45) NOT NULL,
  `numeroFactura` VARCHAR(45) NULL,
  `factura` INT NULL,
  `filial` INT NOT NULL,
  `empleadoAsignado` INT NOT NULL,
  `tipoSolicitud_idSolicitud` INT NOT NULL,
  `respuesta` VARCHAR(1000) NULL,
  `fechaRespuesta` DATE NULL,
  `satisfaccion` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_solicitud_factura1_idx` (`factura` ASC),
  INDEX `fk_solicitud_filial1_idx` (`filial` ASC),
  INDEX `fk_solicitud_empleado1_idx` (`empleadoAsignado` ASC),
  INDEX `fk_solicitud_tipoSolicitud1_idx` (`tipoSolicitud_idSolicitud` ASC),
  CONSTRAINT `fk_solicitud_factura1`
    FOREIGN KEY (`factura`)
    REFERENCES `mydb`.`factura` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_filial1`
    FOREIGN KEY (`filial`)
    REFERENCES `mydb`.`filial` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_empleado1`
    FOREIGN KEY (`empleadoAsignado`)
    REFERENCES `mydb`.`empleado` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitud_tipoSolicitud1`
    FOREIGN KEY (`tipoSolicitud_idSolicitud`)
    REFERENCES `mydb`.`tipoSolicitud` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`producto` ;

CREATE TABLE IF NOT EXISTS `mydb`.`producto` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`facturaProducto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`facturaProducto` ;

CREATE TABLE IF NOT EXISTS `mydb`.`facturaProducto` (
  `factura` INT NOT NULL,
  `producto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`factura`, `producto`),
  INDEX `fk_facturaProducto_producto1_idx` (`producto` ASC),
  CONSTRAINT `fk_facturaProducto_factura1`
    FOREIGN KEY (`factura`)
    REFERENCES `mydb`.`factura` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturaProducto_producto1`
    FOREIGN KEY (`producto`)
    REFERENCES `mydb`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`tipoSolicitud`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`tipoSolicitud` (`id`, `nombre`) VALUES (1, 'peticion');
INSERT INTO `mydb`.`tipoSolicitud` (`id`, `nombre`) VALUES (2, 'queja');
INSERT INTO `mydb`.`tipoSolicitud` (`id`, `nombre`) VALUES (3, 'sugerencia');
INSERT INTO `mydb`.`tipoSolicitud` (`id`, `nombre`) VALUES (4, 'reclamo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`filial`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`filial` (`id`, `nombre`, `codigo`) VALUES (1, 'Centro Maravilloso', 'centro');
INSERT INTO `mydb`.`filial` (`id`, `nombre`, `codigo`) VALUES (2, 'Oriente Tech', 'oriente');
INSERT INTO `mydb`.`filial` (`id`, `nombre`, `codigo`) VALUES (3, 'Occi Compras', 'occidente');
INSERT INTO `mydb`.`filial` (`id`, `nombre`, `codigo`) VALUES (4, 'Surface', 'sur');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`factura`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`factura` (`id`, `fechaVenta`, `filial`) VALUES (1, '2016-12-12 15:25:15', 1);
INSERT INTO `mydb`.`factura` (`id`, `fechaVenta`, `filial`) VALUES (2, '2017-01-25 10:20:00', 4);
INSERT INTO `mydb`.`factura` (`id`, `fechaVenta`, `filial`) VALUES (3, '2017-02-23 16:45:12', 3);
INSERT INTO `mydb`.`factura` (`id`, `fechaVenta`, `filial`) VALUES (4, '2017-03-11 09:13:00', 2);
INSERT INTO `mydb`.`factura` (`id`, `fechaVenta`, `filial`) VALUES (5, '2017-04-21 14:55:02', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`tipoEmpleado`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`tipoEmpleado` (`id`, `nombrel`, `codigo`) VALUES (1, 'Gerente de Cuentas Corporativas', 'gerente_cc');
INSERT INTO `mydb`.`tipoEmpleado` (`id`, `nombrel`, `codigo`) VALUES (2, 'Empleado Administrativo', 'admin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`empleado`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`empleado` (`id`, `nombre`, `tipoEmpleado`) VALUES (1, 'Antonio Garcia', 1);
INSERT INTO `mydb`.`empleado` (`id`, `nombre`, `tipoEmpleado`) VALUES (2, 'Roberto Perez', 2);
INSERT INTO `mydb`.`empleado` (`id`, `nombre`, `tipoEmpleado`) VALUES (3, 'Pedro Sanchez', 2);
INSERT INTO `mydb`.`empleado` (`id`, `nombre`, `tipoEmpleado`) VALUES (4, 'Andrea Guzman', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`producto`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (1, 'televisor', 500000);
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (2, 'nevera', 800000);
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (3, 'microondas', 300000);
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (4, 'computador mesa', 1000000);
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (5, 'computador portatil', 1100000);
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (6, 'tablet', 700000);
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (7, 'smartphone', 400000);
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (8, 'lavadora', 900000);
INSERT INTO `mydb`.`producto` (`id`, `nombre`, `precio`) VALUES (9, 'aire acodicionado', 950000);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`facturaProducto`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`facturaProducto` (`factura`, `producto`, `cantidad`) VALUES (1, 2, 1);
INSERT INTO `mydb`.`facturaProducto` (`factura`, `producto`, `cantidad`) VALUES (1, 3, 1);
INSERT INTO `mydb`.`facturaProducto` (`factura`, `producto`, `cantidad`) VALUES (2, 9, 1);
INSERT INTO `mydb`.`facturaProducto` (`factura`, `producto`, `cantidad`) VALUES (3, 4, 1);
INSERT INTO `mydb`.`facturaProducto` (`factura`, `producto`, `cantidad`) VALUES (4, 1, 1);
INSERT INTO `mydb`.`facturaProducto` (`factura`, `producto`, `cantidad`) VALUES (5, 2, 1);
INSERT INTO `mydb`.`facturaProducto` (`factura`, `producto`, `cantidad`) VALUES (5, 8, 1);
INSERT INTO `mydb`.`facturaProducto` (`factura`, `producto`, `cantidad`) VALUES (4, 5, 1);

COMMIT;

