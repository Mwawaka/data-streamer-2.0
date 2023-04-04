## checking whether a message has been published to the broker
### - bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic Weather-Cast-Data --partition 0 --from-beginning

### SQL QUERIES
#### CREATE OR REPLACE FUNCTION update_max_temp_celsius() RETURNS TRIGGER AS $$
#### BEGIN
#### NEW.max_temp_celsius := NEW.temperature - 273.15;
#### RETURN NEW;
#### END;
#### $$ LANGUAGE plpgsql;
#### 
#### CREATE TRIGGER weather_data_max_temp_celsius_trigger
#### BEFORE INSERT OR UPDATE ON weather_data
#### FOR EACH ROW
#### WHEN (NEW.temperature IS NOT NULL)
#### EXECUTE FUNCTION update_max_temp_celsius();

