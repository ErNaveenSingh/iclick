package naveen.imageclickapp;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.util.ArrayList;


public class PinView extends SubsamplingScaleImageView {

    private ArrayList<NavigationPoint> sPinList = new ArrayList<>();
    private Bitmap pin;
    private ArrayList<PathPoint>  mPathList = new ArrayList<>();

    private ArrayList<Polygon>  mPolygonList = new ArrayList<>();
    private Path mPath;
    private Paint mPaint;
    private Paint mPaintFill;
    private float scale =0;

    private static final int MAX_CLICK_DURATION = 200;
    private long startClickTime;

    private float pinHeight=0;
    private float pinWidth=0;

    public PinView(Context context) {
        this(context, null);
    }

    public PinView(Context context, AttributeSet attr) {
        super(context, attr);
        initialise();
    }

//    public void setPin(PointF sPin) {
//        this.sPin = sPin;
//        initialise();
//        invalidate();
//    }

    public void addPin(NavigationPoint sPin) {
        this.sPinList.add(sPin);
        initialise();
        invalidate();
    }

    public void addToPath(PathPoint sPin) {
        this.mPathList.add(sPin);
    }

    public void clearPath(){
        this.mPathList.clear();
    }

    public ArrayList<NavigationPoint> getsPinList() {
        return sPinList;
    }

    public float getPinHeight() {
        return pinHeight;
    }

    public float getPinWidth() {
        return pinWidth;
    }

    public void addPolygon(Polygon polygon){
        if (polygon!=null)
            mPolygonList.add(polygon);
    }
    //    public PointF getPin() {
//        return sPin;
//    }

    private void initialise() {
        float density = getResources().getDisplayMetrics().densityDpi;
        pin = BitmapFactory.decodeResource(this.getResources(), R.drawable.pushpin_blue);
        pinWidth = (density/620f) * 40;
        pinHeight = (density/620f) * 65;
        if (scale>0){
            pinWidth = pinWidth*scale;
            pinHeight = pinHeight*scale;
        }
        pin = Bitmap.createScaledBitmap(pin, (int)pinWidth, (int)pinHeight, true);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        mPaint.setStrokeWidth(6f);

        if (scale>0) {
            mPaint.setStrokeWidth(6f*scale);
            mPaint.setPathEffect(new DashPathEffect(new float[] { 10*scale, 10*scale }, 0));
        }
        mPaintFill = new Paint();
        mPaintFill.setAntiAlias(true);
        mPaintFill.setColor(Color.YELLOW);
        mPaintFill.setStyle(Paint.Style.FILL);


        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Log.d("TAG", "initialise: "+getScale());
        // Don't draw pin before image is ready so it doesn't move around during setup.
        if (!isReady()) {
            return;
        }

        if (getScale()!=scale){
            scale = getScale();
            initialise();
        }

        Paint paint = new Paint();
        paint.setAntiAlias(true);


        if (mPathList!=null && mPathList.size()>0){
            mPath.reset();
            for (PathPoint mPoint: mPathList){
                PointF vPin = sourceToViewCoord(new PointF(mPoint.x, mPoint.y));
                if (mPoint.pointType==0){
                    mPath.moveTo(vPin.x, vPin.y);
                }else if (mPoint.pointType==1){
                    mPath.lineTo(vPin.x, vPin.y);
                }
            }

            canvas.drawPath(mPath, mPaint);

        }

        if (sPinList.size()>0) {
            for (NavigationPoint sPin:
                    sPinList) {

                if (sPin != null && pin != null) {
                    PointF vPin = sourceToViewCoord(new PointF(sPin.x, sPin.y));
                    float vX = vPin.x - (pin.getWidth()/2);
                    float vY = vPin.y - (pin.getHeight()/2);
                    canvas.drawBitmap(pin, vX, vY, paint);
                }
            }
        }

        if (mPolygonList.size()>0){
            for (Polygon polygon:
                    mPolygonList) {
                Path path = new Path();
                if (polygon.points.length>2){
                    for (int i=0;i<polygon.points.length;i++){
                        PointF vPin = sourceToViewCoord(new PointF(polygon.points[i].x, polygon.points[i].y));
                        if (i==0)
                            path.moveTo(vPin.x, vPin.y);
                        else
                            path.lineTo(vPin.x, vPin.y);
                    }
                    PointF vPin = sourceToViewCoord(new PointF(polygon.points[0].x, polygon.points[0].y));
                    path.lineTo(vPin.x, vPin.y);

                    canvas.drawPath(path, mPaintFill);
                }
            }
        }

    }

//    @Override
//    public boolean onTouchEvent(@NonNull MotionEvent event) {
//
//        float x = event.getX();
//        float y = event.getY();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN: {
//                startClickTime = Calendar.getInstance().getTimeInMillis();
//                break;
//            }
//            case MotionEvent.ACTION_UP: {
//
//                long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
//                if(clickDuration < MAX_CLICK_DURATION) {
//                    Log.d("TAG", "onTouchEvent: click x:"+x+", y:"+y);
//                    if (sPinList.size()>0) {
//                        for (NavigationPoint sPin:
//                                sPinList) {
//
//                            if (sPin != null) {
//                                if (x>=sPin.x && x<=(sPin.x+pinWidth) && y>=sPin.y && y<=(sPin.y+pinHeight)){
//                                    Log.d("TAG", "onTouchEvent: pin pressed"+sPin.pinTag);
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return super.onTouchEvent(event);
//    }


}
