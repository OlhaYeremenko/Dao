-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 11 2015 г., 19:53
-- Версия сервера: 5.6.24
-- Версия PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `habit`
--

-- --------------------------------------------------------

--
-- Структура таблицы `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `idcity` int(5) NOT NULL,
  `ncity` varchar(100) NOT NULL,
  `square` int(50) NOT NULL,
  `age` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `city`
--

INSERT INTO `city` (`idcity`, `ncity`, `square`, `age`) VALUES
(1, 'Kharkov', 1500000, 1850),
(2, 'Kiev', 2300000, 1650),
(3, 'Odessa', 80000, 1689),
(4, 'Lviv', 50000, 1500);

-- --------------------------------------------------------

--
-- Структура таблицы `habitamount`
--

CREATE TABLE IF NOT EXISTS `habitamount` (
  `idamount` int(5) NOT NULL,
  `idcity` int(5) NOT NULL,
  `idhabit` int(5) NOT NULL,
  `amount` int(40) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `habitamount`
--

INSERT INTO `habitamount` (`idamount`, `idcity`, `idhabit`, `amount`) VALUES
(1, 2, 2, 154000),
(2, 2, 1, 160000),
(3, 4, 1, 180000),
(4, 3, 1, 200000);

-- --------------------------------------------------------

--
-- Структура таблицы `habittype`
--

CREATE TABLE IF NOT EXISTS `habittype` (
  `idhabit` int(5) NOT NULL,
  `type` varchar(15) NOT NULL,
  `language` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `habittype`
--

INSERT INTO `habittype` (`idhabit`, `type`, `language`) VALUES
(1, 'europeans', 'ukrainian'),
(2, 'tatars', 'tatrsky');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`idcity`);

--
-- Индексы таблицы `habitamount`
--
ALTER TABLE `habitamount`
  ADD PRIMARY KEY (`idamount`);

--
-- Индексы таблицы `habittype`
--
ALTER TABLE `habittype`
  ADD PRIMARY KEY (`idhabit`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `city`
--
ALTER TABLE `city`
  MODIFY `idcity` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `habitamount`
--
ALTER TABLE `habitamount`
  MODIFY `idamount` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `habittype`
--
ALTER TABLE `habittype`
  MODIFY `idhabit` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
