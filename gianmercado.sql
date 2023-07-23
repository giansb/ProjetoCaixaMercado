-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Jul-2023 às 05:08
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `gianmercado`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL,
  `tipo_pagamento` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `preco` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idproduto`, `nome`, `preco`) VALUES
(512, 'coca-cola 400ml', 7.99),
(612, 'paçoca', 2),
(712, 'Baly Lata 500ml', 7.99);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_has_pedido`
--

CREATE TABLE `produto_has_pedido` (
  `id_produto_has_pedido` int(11) NOT NULL,
  `qtd` int(11) DEFAULT NULL,
  `precototal` double DEFAULT NULL,
  `produto_idproduto` int(11) DEFAULT NULL,
  `pedido_idpedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idpedido`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idproduto`);

--
-- Índices para tabela `produto_has_pedido`
--
ALTER TABLE `produto_has_pedido`
  ADD PRIMARY KEY (`id_produto_has_pedido`),
  ADD KEY `fk_produto` (`produto_idproduto`),
  ADD KEY `fk_pedido` (`pedido_idpedido`);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `produto_has_pedido`
--
ALTER TABLE `produto_has_pedido`
  ADD CONSTRAINT `fk_pedido` FOREIGN KEY (`pedido_idpedido`) REFERENCES `pedido` (`idpedido`),
  ADD CONSTRAINT `fk_produto` FOREIGN KEY (`produto_idproduto`) REFERENCES `produto` (`idproduto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
