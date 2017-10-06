package Utils;

/**
 * Created by jsmall on 2/10/2017.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateTime {

    private String dateTime;
    private String zone;


    public DateTime() {}

    public String getDateTime() { return this.dateTime; }
    public String getZone() { return this.zone; }

    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    public void setZone(String zone) { this.zone = zone; }

    @Override
    public String toString() {
        return "\"dateTime\": \"" + dateTime + "\"," +
                "\"zone\": \"" + zone + "\"";
    }
}
