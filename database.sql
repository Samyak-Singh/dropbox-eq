mysql> create database dropbox; -- Creates the new database
mysql> create user 'guest' identified by 'password'; -- Creates the user
mysql> grant all on dropbox.* to 'guest'; -- Gives all privileges to the new user on the newly created database