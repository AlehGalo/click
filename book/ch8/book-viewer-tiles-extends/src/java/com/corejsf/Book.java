package com.corejsf;

import java.util.LinkedList;
import java.util.List;

public class Book {
   private String titleKey;
   private String image;
   private int numChapters;
   private List<String> chapterKeys = null;

   // PROPERTY: titleKey
   public void setTitleKey(String titleKey) { this.titleKey = titleKey; }
   public String getTitleKey() { return titleKey; }

   // PROPERTY: image
   public void setImage(String image) { this.image = image; }
   public String getImage() { return image; }

   // PROPERTY: numChapters
   public void setNumChapters(int numChapters) { this.numChapters = numChapters;}
   public int getNumChapters() { return numChapters; }

   // PROPERTY: chapterKeys
   public List<String> getChapterKeys() {
      if(chapterKeys == null) {
         chapterKeys = new LinkedList<String>();
         for(int i=1; i <= numChapters; ++i)
            chapterKeys.add("chapter" + i);   
      }
      return chapterKeys;
   }
}
