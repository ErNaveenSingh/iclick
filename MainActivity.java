package naveen.imageclickapp;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.davemorrissey.labs.subscaleview.ImageSource;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";
    PinView imageView;
    GestureDetector gestureDetector;
    EditText startPoint;
    EditText endPoint;
    int id = 1;
    boolean isIDAdded = false;
    StringBuffer boxString ;
    ArrayList<Polygon> mPolygons =  new ArrayList<>();
    DataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSource = new DataSource();
        boxString = new StringBuffer();
        startPoint = (EditText) findViewById(R.id.start_point_editText);
        endPoint = (EditText) findViewById(R.id.end_point_editText);

        imageView = (PinView) findViewById(R.id.imageView);

        imageView.setImage(ImageSource.asset("path2.png"));
        imageView.setMinimumDpi(10);
        gestureDetector = new GestureDetector(this, gestureListner);
        imageView.setOnTouchListener((View.OnTouchListener) new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.clearPath();
                imageView.invalidate();
                if (startPoint.getText().toString().length() > 0 && endPoint.getText().toString().length() > 0)
                    createPath(Integer.parseInt(startPoint.getText().toString()), Integer.parseInt(endPoint.getText().toString()));

            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isIDAdded) {
                    Log.d(TAG, "onClick: " +id+", "+ (int) imageView.getCenter().x + ", " + (int) imageView.getCenter().y);
                    boxString.append(id+", "+ (int) imageView.getCenter().x + ", " + (int) imageView.getCenter().y);
                    isIDAdded=true;
                }else{
                    Log.d(TAG, "onClick: " + (int) imageView.getCenter().x + ", " + (int) imageView.getCenter().y);
                    boxString.append(", "+ (int) imageView.getCenter().x + ", " + (int) imageView.getCenter().y);

                }

            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id++;
                isIDAdded = false;
                Log.d(TAG, "final box: "+boxString.toString());

//                Polygon newPolygon =dataSource.convertToPolygon(boxString.toString());
//                if (newPolygon!=null)
//                    imageView.addPolygon(newPolygon);
                boxString.setLength(0);
            }
        });

        mPolygons = dataSource.mPolygons;
//        for (Polygon polygon:
//             mPolygons) {
//            imageView.addPolygon(polygon);
//        }
        id = mPolygons.size()+1;
    }

    public void createPath(int startingPointID, int endPointID) {

        ArrayList<NavigationPoint> pointsList = dataSource.mPointsList;
        ArrayList<NavigationPointsDistance> distancePointsList = dataSource.mPointsDistanceList;
//        DijkstraAlgorithmCopy dijkstraCopy = new DijkstraAlgorithmCopy(pointsList, distancePointsList);
//        dijkstraCopy.findPath(dijkstraCopy.getNavigationPointForId(startingPointID), dijkstraCopy.getNavigationPointForId(endPointID));
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(pointsList, distancePointsList);
        dijkstra.execute(dijkstra.getNavigationPointForId(startingPointID));
//
        NavigationPoint endPoint = new NavigationPoint(dijkstra.getNavigationPointForId(endPointID));
        LinkedList<NavigationPoint> path = dijkstra.getPath(endPoint);
//
        if (path != null) {
            boolean isFirst = true;
            for (NavigationPoint vertex : path) {
//            Log.d("PATH", "createPath: "+vertex.navigationPointId);
                if (isFirst) {
                    isFirst=false;
                    imageView.addToPath(new PathPoint(vertex, 0));
                }
                else{
                    imageView.addToPath(new PathPoint(vertex, 1));
                }
            }
        }


    }

    GestureDetector.SimpleOnGestureListener gestureListner = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (imageView.isReady()) {
                PointF soord = imageView.viewToSourceCoord(e.getX(), e.getY());

                float x = soord.x;
                float y = soord.y;
                Log.d("TAG", "Single tap:  mPointsList.add(new NavigationPoint(" + ((int) soord.x) + ", " + ((int) soord.y) + ", 00))");
                Log.d("TAG", "Single tap:  " + ((int) soord.x) + ", " + ((int) soord.y) + "");

                for (Polygon polygon:mPolygons){
                    if(contains(new Point((int)x, (int)y), polygon.points))
                    {
                        Log.d("TAG", "Inside the box "+polygon.id);
                    }
                }
            } else {
                Log.d("TAG", "Image not ready");
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {

            return true;
        }
    };


    public boolean contains(Point test, Point[] points) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i].y > test.y) != (points[j].y > test.y) &&
                    (test.x < (points[j].x - points[i].x) * (test.y - points[i].y) / (points[j].y-points[i].y) + points[i].x)) {
                result = !result;
            }
        }
        return result;
    }

}