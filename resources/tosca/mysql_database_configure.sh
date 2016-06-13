# Setup MySQL root password and create user
#cat << EOF | mysql -u root --password=password CREATE DATABASE name;
#GRANT ALL PRIVILEGES ON name.* TO "root"@"localhost" IDENTIFIED BY "password";
cat << EOF | mysql -u root --password=password
GRANT ALL PRIVILEGES ON name.* TO "root"@"localhost" IDENTIFIED BY "password";
CREATE DATABASE IF NOT EXISTS name;
FLUSH PRIVILEGES;
EXIT
EOF
