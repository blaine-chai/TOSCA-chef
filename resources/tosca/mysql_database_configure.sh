# Setup MySQL root password and create user
cat << EOF | mysql -u root --password=db_root_password CREATE DATABASE name;
GRANT ALL PRIVILEGES ON name.* TO "user"@"localhost" IDENTIFIED BY "password";
FLUSH PRIVILEGES;
EXIT
EOF
