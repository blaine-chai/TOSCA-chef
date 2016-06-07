# See http://docs.chef.io/config_rb_knife.html for more information on knife configuration options

current_dir = File.dirname(__FILE__)
log_level                :info
log_location             STDOUT
node_name                "blainechai"
client_key               "#{current_dir}/blainechai.pem"
validation_client_name   "smsd-cloud-team-validator"
validation_key           "#{current_dir}/smsd-cloud-team-validator.pem"
chef_server_url          "https://api.chef.io/organizations/smsd-cloud-team"
cookbook_path            ["#{current_dir}/../cookbooks"]
