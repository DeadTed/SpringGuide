Связь Java приложений с БД
JDBC API - самый низкоуровневый (сами делаем все запросы у бд, и сами переводим Java объекты в строки таблицы и
наоборот)
JdbcTemplate - тонкая обертка над JDBC API. Часть Spring Framework. Предоставляет некоторые абстракции, ,берёт часть дел
на себя.
Hibernate - самый высокий уровень абстракции. Практически не пишем вручную запросы к БД. Автоматически переводит Java
объекты в строки таблицы наоборот. Может автоматически создавать таблицы в БД на основании наших Java классов. Этот
функционал называется ORM(Object-Relational Mapping)

DDL(Data Definition Language) - Create,Drop
DML(Data Manipulation Language) - Select,Insert,Update,Delete springguide\postgres

Варианты подключение к БД
1.Statement:
a.SQL запрос компилируется каждый раз
Statement statement = connection.createStatement();
statement.executeUpdate("INSERT into dataset values('Iphone',1000)");
statement.executeUpdate("INSERT into dataset values('Android',500)");
б.Подвержен SQL инъекциям т.д. передаёт запрос напрямую к БД

2.PreparedStatement
a.SQL запрос компилируется один раз
PreparedStatement preparedStatement = connection.preparedStatement("INSERT into dataset values(?,?)");
preparedStatement.setString(1,"Iphone");
preparedStatement.setInt(2,1000);
preparedStatement.executeUpdate;
preparedStatement.setString(1,"Android");
preparedStatement.setInt(2,500);
preparedStatement.executeUpdate;
б.Защищает от SQL инъекций
в.Может кэшироваться в самой БД