package com.delta.bookshelf;

/**
 * Created by spawrks on 2/22/14.
 */

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * BaseAdapter extension with lazy loading. Item template is designed in
 * res/layout/row.xml
*/

public class LazyAdapter extends BaseAdapter {
    private ListActivity activity;
    private LayoutInflater layoutInflater;
    private ArrayList<String> names;
    private FacebookEntity[] cachedEntities;
    private int cacheSize = 0;

    public LazyAdapter(ListActivity activity, ArrayList<String> names) {
        super();
        this.activity = activity;
        this.names = names;
        this.cachedEntities = new FacebookEntity[this.names.size()];
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        new FetchDataTask(this, 0).execute();
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        FacebookEntity cachedEntity = cachedEntities[position]; // trying to get a user from cache

        View row = convertView;
        ViewHolder viewHolder;

        if (row == null) {
            row = layoutInflater.inflate(R.layout.row, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) row.findViewById(R.id.nameTextView);
            viewHolder.spinner = (ProgressBar) row.findViewById(R.id.progressBar);
            viewHolder.imageView = (ImageView) row.findViewById(R.id.imageView);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) row.getTag();
        }

        if (cachedEntity != null) {
            viewHolder.textView.setText(cachedEntity.getName());
            viewHolder.spinner.setVisibility(View.GONE);
            if(cachedEntity.getBitmap() != null){
                Bitmap b = roundCornerImage(cachedEntity.getBitmap(),5.0f);
                viewHolder.imageView.setImageBitmap(b);
            }
        } else {
            viewHolder.textView.setText("");
            viewHolder.spinner.setVisibility(View.VISIBLE);

        }

        return row;
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    public void saveEntity(FacebookEntity user) {
        cachedEntities[cacheSize] = user;
        cacheSize++;
        notifyDataSetChanged(); //reload ListView
    }

    private static class ViewHolder {
        public TextView textView;
        public ProgressBar spinner;
        public ImageView imageView;
    }

    public Bitmap roundCornerImage(Bitmap src, float round) {

        // Source image size
        int width = src.getWidth();
        int height = src.getHeight();
        // create result bitmap output
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        // set canvas for painting
        Canvas canvas = new Canvas(result);
        canvas.drawARGB(0, 0, 0, 0);

        // configure paint
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);

        // configure rectangle for embedding
        final Rect rect = new Rect(0, 0, width, height);
        final RectF rectF = new RectF(rect);

        // draw Round rectangle to canvas
        canvas.drawRoundRect(rectF, round, round, paint);

        // create Xfer mode
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // draw source image to canvas
        canvas.drawBitmap(src, rect, rect, paint);

        // return final image
        return result;
    }
}