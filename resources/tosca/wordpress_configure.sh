#sed -i "/Deny from All/d" /etc/apache2/conf.d/wordpress.conf
#sed -i "s/Require local/Require all granted/" /etc/apache2/conf.d/wordpress.conf
ln -s /usr/share/wordpress /var/www/wordpress
bash /usr/share/doc/wordpress/examples/setup-mysql -n wordpress localhost
sed -i s/database_name_here/name/ /etc/wordpress/wp-config.php
sed -i s/username_here/user/ /etc/wordpress/wp-config.php
sed -i s/password_here/password/ /etc/wordpress/wp-config.php
/etc/init.d/apache2 start
