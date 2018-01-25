package com.satyahair.skinnhair.view.custom;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import org.xml.sax.XMLReader;

/**
 * Created by Sandeep on 25/12/2016.
 */

public class HtmlTextView extends TextView {
    public HtmlTextView(Context context) {
        super(context);
    }

    public HtmlTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HtmlTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HtmlTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            super.setText(Html.fromHtml(text.toString(),Html.FROM_HTML_MODE_LEGACY,null,new MyTagHandler()),type);
        }else {
            super.setText(Html.fromHtml(text.toString(),null,new MyTagHandler()),type);
        }
    }
    public class MyTagHandler implements Html.TagHandler {
        boolean first= true;
        String parent=null;
        int index=1;
        @Override
        public void handleTag(boolean opening, String tag, Editable output,
                              XMLReader xmlReader) {

            if(tag.equals("ul")) parent="ul";
            else if(tag.equals("ol")) parent="ol";
            if(tag.equals("li")){
                if(parent.equals("ul")){
                    if(first){
                        output.append("\n\t•");
                        first= false;
                    }else{
                        first = true;
                    }
                }
                else{
                    if(first){
                        output.append("\n\t"+index+". ");
                        first= false;
                        index++;
                    }else{
                        first = true;
                    }
                }
            }
        }
    }
}
