Este é meu primeiro projeto executado como prova no meu curso de ADS
Fazer login e execuar o CRUD completo de uma sistema bara uma empresa de banho e tosa de animais.

# Trabalho

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24/06/2023 às 01:24
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `petshop`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `telefone` varchar(14) NOT NULL,
  `funcao` int(2) NOT NULL COMMENT '1 - adm\r\n2 - veterin\r\n3 - banho\r\n4 - recep',
  `senha` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `login`
--

CREATE TABLE `login` (
  `username` varchar(40) NOT NULL,
  `senha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `login`
--

INSERT INTO `login` (`username`, `senha`) VALUES
('Daniel', '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `ordemservico`
--

CREATE TABLE `ordemservico` (
  `id_ordem` int(11) NOT NULL,
  `data` date NOT NULL,
  `valor` double(12,2) NOT NULL,
  `servico` varchar(20) NOT NULL,
  `id_pet` int(11) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  `finalizado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `ordemservicoitem`
--

CREATE TABLE `ordemservicoitem` (
  `idItemServico` int(11) NOT NULL,
  `idOrdemServico` int(11) NOT NULL,
  `idServico` int(11) NOT NULL,
  `idAnimal` int(11) NOT NULL,
  `precoUnitario` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pets`
--

CREATE TABLE `pets` (
  `id_pet` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `idade` int(3) NOT NULL,
  `id_tutor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pets`
--

INSERT INTO `pets` (`id_pet`, `nome`, `tipo`, `idade`, `id_tutor`) VALUES
(1, 'Rex', 'Cachorro', 6, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `servicos`
--

CREATE TABLE `servicos` (
  `idServico` int(11) NOT NULL,
  `nomeServico` varchar(80) NOT NULL,
  `precoServico` double NOT NULL,
  `quantidadeServico` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `servicos`
--

INSERT INTO `servicos` (`idServico`, `nomeServico`, `precoServico`, `quantidadeServico`) VALUES
(10, 'Banho e Tosa Com Corte de Unhas Especiais', 45, 1),
(11, 'Banho e Tosa Simples', 25, 1),
(12, 'Banho e Tosa Simples Com Talco', 25, 1),
(20, 'Penteado Para Festa', 50, 1),
(22, 'Banho e Tosa Especial', 50, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tutor`
--

CREATE TABLE `tutor` (
  `id_tutor` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `endereco` varchar(40) NOT NULL,
  `telefone` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tutor`
--

INSERT INTO `tutor` (`id_tutor`, `nome`, `endereco`, `telefone`) VALUES
(1, 'Daniel', 'Rua Tal 45', '31988831-8293');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id_funcionario`);

--
-- Índices de tabela `ordemservico`
--
ALTER TABLE `ordemservico`
  ADD PRIMARY KEY (`id_ordem`),
  ADD KEY `id_funcionario` (`id_funcionario`),
  ADD KEY `id_pet` (`id_pet`);

--
-- Índices de tabela `ordemservicoitem`
--
ALTER TABLE `ordemservicoitem`
  ADD PRIMARY KEY (`idItemServico`),
  ADD KEY `FK_item_pet` (`idAnimal`),
  ADD KEY `FK_item_servico` (`idServico`),
  ADD KEY `FK_item_OrdemServico` (`idOrdemServico`);

--
-- Índices de tabela `pets`
--
ALTER TABLE `pets`
  ADD PRIMARY KEY (`id_pet`),
  ADD KEY `id_tutor` (`id_tutor`);

--
-- Índices de tabela `servicos`
--
ALTER TABLE `servicos`
  ADD PRIMARY KEY (`idServico`);

--
-- Índices de tabela `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`id_tutor`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id_funcionario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `ordemservico`
--
ALTER TABLE `ordemservico`
  MODIFY `id_ordem` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `ordemservicoitem`
--
ALTER TABLE `ordemservicoitem`
  MODIFY `idItemServico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pets`
--
ALTER TABLE `pets`
  MODIFY `id_pet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `servicos`
--
ALTER TABLE `servicos`
  MODIFY `idServico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de tabela `tutor`
--
ALTER TABLE `tutor`
  MODIFY `id_tutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `ordemservico`
--
ALTER TABLE `ordemservico`
  ADD CONSTRAINT `ordemservico_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`),
  ADD CONSTRAINT `ordemservico_ibfk_2` FOREIGN KEY (`id_pet`) REFERENCES `pets` (`id_pet`);

--
-- Restrições para tabelas `ordemservicoitem`
--
ALTER TABLE `ordemservicoitem`
  ADD CONSTRAINT `FK_item_OrdemServico` FOREIGN KEY (`idOrdemServico`) REFERENCES `ordemservico` (`id_ordem`),
  ADD CONSTRAINT `FK_item_pet` FOREIGN KEY (`idAnimal`) REFERENCES `pets` (`id_pet`),
  ADD CONSTRAINT `FK_item_servico` FOREIGN KEY (`idServico`) REFERENCES `servicos` (`idServico`);

--
-- Restrições para tabelas `pets`
--
ALTER TABLE `pets`
  ADD CONSTRAINT `pets_ibfk_1` FOREIGN KEY (`id_tutor`) REFERENCES `tutor` (`id_tutor`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
