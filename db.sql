ALTER TABLE weather_data
    ADD COLUMN max_temp_celsius NUMERIC;

-----------------------------------------------------------------------------------------
UPDATE weather_data
SET max_temp_celsius = (maximum_temperature - 273.15)
WHERE temperature IS NOT NULL;


ALTER TABLE weather_data
    ALTER COLUMN max_temp_celsius SET NOT NULL;

-----------------------------------------------------------------------------------------
ALTER TABLE weather_data
    ADD COLUMN date_form TEXT;

UPDATE weather_data
SET date_form = to_char(date_time::timestamp with time zone, 'YYYY-MM-DD HH24:MI:SS')
WHERE date_time is not null;



ALTER TABLE weather_data
    ALTER COLUMN date_form SET NOT NULL;

-----------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION update_datetime_formatted()
    RETURNS TRIGGER AS
$BODY$
BEGIN
    IF NEW.date_time IS NOT NULL THEN
        NEW.date_form := to_char(NEW.date_time::timestamp with time zone, 'MM-DD HH24:MI:SS');
    END IF;
    RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER update_datetime_trigger
    BEFORE INSERT OR UPDATE
    ON weather_data
    FOR EACH ROW
EXECUTE FUNCTION update_datetime_formatted();

-----------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION update_max_temp_celsius() RETURNS TRIGGER AS
$$
BEGIN
    NEW.max_temp_celsius := NEW.temperature - 273.15;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER weather_data_max_temp_celsius_trigger
    BEFORE INSERT OR UPDATE
    ON weather_data
    FOR EACH ROW
    WHEN (NEW.temperature IS NOT NULL)
EXECUTE FUNCTION update_max_temp_celsius();

-----------------------------------------------------------------------------------------
ALTER TABLE weather_data
    ADD COLUMN unix_time TIMESTAMP;
