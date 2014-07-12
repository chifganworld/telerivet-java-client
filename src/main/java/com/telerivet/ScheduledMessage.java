
package com.telerivet;
        
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
        
/**
    ScheduledMessage
    
    Represents a scheduled message within Telerivet.
    
    Fields:
    
      - id (string, max 34 characters)
          * ID of the scheduled message
          * Read-only
      
      - content
          * Text content of the scheduled message
          * Read-only
      
      - rrule
          * Recurrence rule for recurring scheduled messages, e.g. 'FREQ=MONTHLY' or
              'FREQ=WEEKLY;INTERVAL=2'; see <https://tools.ietf.org/html/rfc2445#section-4.3.10>
          * Read-only
      
      - timezone_id
          * Timezone ID used to compute times for recurring messages; see
              <http://en.wikipedia.org/wiki/List_of_tz_database_time_zones>
          * Read-only
      
      - group_id
          * ID of the group to send the message to (null if scheduled to an individual contact)
          * Read-only
      
      - contact_id
          * ID of the contact to send the message to (null if scheduled to a group)
          * Read-only
      
      - to_number
          * Phone number to send the message to (null if scheduled to a group)
          * Read-only
      
      - route_id
          * ID of the phone or route to the message will be sent from
          * Read-only
      
      - message_type
          * Type of scheduled message
          * Allowed values: sms, ussd
          * Read-only
      
      - time_created (UNIX timestamp)
          * Time the scheduled message was created in Telerivet
          * Read-only
      
      - start_time (UNIX timestamp)
          * The time that the message will be sent (or first sent for recurring messages)
          * Read-only
      
      - end_time (UNIX timestamp)
          * Time after which a recurring message will stop (not applicable to non-recurring
              scheduled messages)
          * Read-only
      
      - prev_time (UNIX timestamp)
          * The most recent time that Telerivet has sent this scheduled message (null if it has
              never been sent)
          * Read-only
      
      - next_time (UNIX timestamp)
          * The next upcoming time that Telerivet will sent this scheduled message (null if it
              will not be sent again)
          * Read-only
      
      - occurrences (int)
          * Number of times this scheduled message has already been sent
          * Read-only
      
      - is_template (bool)
          * Set to true if Telerivet will render variables like [[contact.name]] in the message
              content, false otherwise
          * Read-only
      
      - vars (JSONObject)
          * Custom variables stored for this scheduled message (copied to Message when sent)
          * Updatable via API
      
      - label_ids (array)
          * IDs of labels to add to the Message
          * Read-only
      
      - project_id
          * ID of the project this scheduled message belongs to
          * Read-only
*/
public class ScheduledMessage extends Entity
{
    /**
        scheduled_msg.save()
        
        Saves any fields or custom variables that have changed for this scheduled message.
    */
    @Override
    public void save() throws IOException
    {
        super.save();
    }

    /**
        scheduled_msg.delete()
        
        Cancels this scheduled message.
    */
    public void delete() throws IOException
    {
        api.doRequest("DELETE", getBaseApiPath());
    }

    public String getId()
    {
        return (String) get("id");
    }

    public String getContent()
    {
        return (String) get("content");
    }

    public String getRrule()
    {
        return (String) get("rrule");
    }

    public String getTimezoneId()
    {
        return (String) get("timezone_id");
    }

    public String getGroupId()
    {
        return (String) get("group_id");
    }

    public String getContactId()
    {
        return (String) get("contact_id");
    }

    public String getToNumber()
    {
        return (String) get("to_number");
    }

    public String getRouteId()
    {
        return (String) get("route_id");
    }

    public String getMessageType()
    {
        return (String) get("message_type");
    }

    public Long getTimeCreated()
    {
        return Util.toLong(get("time_created"));
    }

    public Long getStartTime()
    {
        return Util.toLong(get("start_time"));
    }

    public Long getEndTime()
    {
        return Util.toLong(get("end_time"));
    }

    public Long getPrevTime()
    {
        return Util.toLong(get("prev_time"));
    }

    public Long getNextTime()
    {
        return Util.toLong(get("next_time"));
    }

    public Integer getOccurrences()
    {
        return (Integer) get("occurrences");
    }

    public Boolean getIsTemplate()
    {
        return (Boolean) get("is_template");
    }

    public JSONArray getLabelIds()
    {
        return (JSONArray) get("label_ids");
    }

    public String getProjectId()
    {
        return (String) get("project_id");
    }

    @Override
    public String getBaseApiPath()
    {
        return "/projects/" + getProjectId() + "/scheduled/" + getId() + "";
    }

    public ScheduledMessage(TelerivetAPI api, JSONObject data)
    {
        this(api, data, true);
    }
    
    public ScheduledMessage(TelerivetAPI api, JSONObject data, boolean isLoaded)
    {
        super(api, data, isLoaded);
    }
}
