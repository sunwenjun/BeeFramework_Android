
package com.example.protocol;

import com.external.activeandroid.Model;
import com.external.activeandroid.annotation.Column;
import com.external.activeandroid.annotation.Table;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@Table(name = "STATUSES")
public class STATUSES  extends Model
{

     @Column(name = "comments_count")
     public int comments_count;

     @Column(name = "text")
     public String   text;

     @Column(name = "in_reply_to_screen_name")
     public String   in_reply_to_screen_name;

     @Column(name = "truncated")
     public boolean truncated;

     @Column(name = "bmiddle_pic")
     public String   bmiddle_pic;

     @Column(name = "thumbnail_pic")
     public String   thumbnail_pic;

     @Column(name = "source")
     public String   source;

     @Column(name = "favorited")
     public boolean favorited;

     @Column(name = "original_pic")
     public String   original_pic;

     @Column(name = "in_reply_to_status_id")
     public String   in_reply_to_status_id;

     @Column(name = "reposts_count")
     public int reposts_count;

     @Column(name = "created_at")
     public String   created_at;

     @Column(name = "in_reply_to_user_id")
     public String   in_reply_to_user_id;

     public ArrayList<String>   annotations = new ArrayList<String>();

     @Column(name = "mid")
     public String   mid;

     @Column(name = "user")
     public USER   user;

     public void  fromJson(JSONObject jsonObject)  throws JSONException
     {
          if(null == jsonObject){
            return ;
           }

          JSONArray subItemArray;

          this.comments_count = jsonObject.optInt("comments_count");

          this.text = jsonObject.optString("text");

          this.in_reply_to_screen_name = jsonObject.optString("in_reply_to_screen_name");

          this.truncated = jsonObject.optBoolean("truncated");

          this.bmiddle_pic = jsonObject.optString("bmiddle_pic");

          this.thumbnail_pic = jsonObject.optString("thumbnail_pic");

          this.source = jsonObject.optString("source");

          this.favorited = jsonObject.optBoolean("favorited");

          this.original_pic = jsonObject.optString("original_pic");

          this.in_reply_to_status_id = jsonObject.optString("in_reply_to_status_id");

          this.reposts_count = jsonObject.optInt("reposts_count");

          this.created_at = jsonObject.optString("created_at");

          this.in_reply_to_user_id = jsonObject.optString("in_reply_to_user_id");

          subItemArray = jsonObject.optJSONArray("annotations");
          if(null != subItemArray)
           {
              for(int i = 0;i < subItemArray.length();i++)
               {
                  String subItemObject = subItemArray.optString(i);
                  String subItem = subItemObject;
                  this.annotations.add(subItem);
               }
           }


          this.mid = jsonObject.optString("mid");
          USER  user = new USER();
          user.fromJson(jsonObject.optJSONObject("user"));
          this.user = user;
          return ;
     }

     public JSONObject  toJson() throws JSONException 
     {
          JSONObject localItemObject = new JSONObject();
          JSONArray itemJSONArray = new JSONArray();
          localItemObject.put("comments_count", comments_count);
          localItemObject.put("text", text);
          localItemObject.put("in_reply_to_screen_name", in_reply_to_screen_name);
          localItemObject.put("truncated", truncated);
          localItemObject.put("bmiddle_pic", bmiddle_pic);
          localItemObject.put("thumbnail_pic", thumbnail_pic);
          localItemObject.put("source", source);
          localItemObject.put("favorited", favorited);
          localItemObject.put("original_pic", original_pic);
          localItemObject.put("in_reply_to_status_id", in_reply_to_status_id);
          localItemObject.put("reposts_count", reposts_count);
          localItemObject.put("created_at", created_at);
          localItemObject.put("in_reply_to_user_id", in_reply_to_user_id);

          for(int i =0; i< annotations.size(); i++)
          {
              String itemData =annotations.get(i);
              itemJSONArray.put(itemData);
          }
          localItemObject.put("annotations", itemJSONArray);
          localItemObject.put("mid", mid);
          if(null != user)
          {
            localItemObject.put("user", user.toJson());
          }
          return localItemObject;
     }

}
