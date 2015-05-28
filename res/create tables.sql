-- --------------------------------------------------------

--
-- Table structure for table `td_enum_difficulty`
--

CREATE TABLE IF NOT EXISTS `td_enum_difficulty` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `td_enum_difficulty`
--

INSERT INTO `td_enum_difficulty` (`id`, `name`) VALUES
(1, 'Easy'),
(2, 'Normal'),
(3, 'Hard'),
(4, 'Insane');

-- --------------------------------------------------------

--
-- Table structure for table `td_scores`
--

CREATE TABLE IF NOT EXISTS `td_scores` (
  `id` varchar(20) NOT NULL,
  `wave` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `gold` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `td_sessions`
--

CREATE TABLE IF NOT EXISTS `td_sessions` (
  `id` varchar(20) NOT NULL,
  `user` varchar(20) NOT NULL,
  `start` bigint(20) NOT NULL,
  `expires` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `td_users`
--

CREATE TABLE IF NOT EXISTS `td_users` (
  `id` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(35) NOT NULL,
  `created` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `td_xref_scores`
--

CREATE TABLE IF NOT EXISTS `td_xref_scores` (
  `id` varchar(20) NOT NULL,
  `user` varchar(20) NOT NULL,
  `score` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`user`,`score`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;