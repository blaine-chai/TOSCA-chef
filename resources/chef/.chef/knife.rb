# See https://docs.getchef.com/config_rb_knife.html for more information on knife configuration options

current_dir = File.dirname(__FILE__)
log_level                :info
log_location             STDOUT
node_name                "blaine"
client_key               "#{current_dir}/blaine.pem"
validation_client_name   "blaine-validator"
validation_key           "#{current_dir}/blaine-validator.pem"
chef_server_url          "https://sangdo-VirtualBox/organizations/blaine"
cookbook_path            ["#{current_dir}/../cookbooks"]
ssl_verify_mode		 :verify_none

knife[:editor] = "/usr/bin/vim"
