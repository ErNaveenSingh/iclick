package naveen.imageclickapp;

import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by naveen on 14/07/16.
 */

public class DataSource {

    final String TAG = "DataSource";

    ArrayList<NavigationPoint> mPointsList =  new ArrayList<>();
    ArrayList<NavigationPointsDistance> mPointsDistanceList =  new ArrayList<>();
    ArrayList<NavigationPointsDirection> mPointsDirectionList =  new ArrayList<>();
    ArrayList<Polygon> mPolygons =  new ArrayList<>();

    public DataSource(){
        initializeDataSource();
    }

    public void initializeDataSource(){
        mPointsList.add(new NavigationPoint(102, 276, 1));
        mPointsList.add(new NavigationPoint(140, 276, 2));
        mPointsList.add(new NavigationPoint(153, 276, 3));
        mPointsList.add(new NavigationPoint(196, 276, 4));
        mPointsList.add(new NavigationPoint(241, 276, 5));
        mPointsList.add(new NavigationPoint(278, 276, 6));
        mPointsList.add(new NavigationPoint(346, 276, 7));
        mPointsList.add(new NavigationPoint(398, 276, 8));
        mPointsList.add(new NavigationPoint(398, 349, 9));
        mPointsList.add(new NavigationPoint(441, 349, 10));
        mPointsList.add(new NavigationPoint(497, 349, 11));
        mPointsList.add(new NavigationPoint(530, 349, 12));
        mPointsList.add(new NavigationPoint(572, 349, 13));
        mPointsList.add(new NavigationPoint(616, 349, 14));
        mPointsList.add(new NavigationPoint(616, 530, 15));
        mPointsList.add(new NavigationPoint(616, 567, 16));
        mPointsList.add(new NavigationPoint(423, 276, 17));
        mPointsList.add(new NavigationPoint(423, 201, 18));
        mPointsList.add(new NavigationPoint(423, 175, 19));
        mPointsList.add(new NavigationPoint(423, 106, 20));
        mPointsList.add(new NavigationPoint(464, 106, 21));
        mPointsList.add(new NavigationPoint(503, 106, 22));
        mPointsList.add(new NavigationPoint(548, 106, 23));
        mPointsList.add(new NavigationPoint(577, 106, 24));
        mPointsList.add(new NavigationPoint(587, 106, 25));
        mPointsList.add(new NavigationPoint(629, 106, 26));
        mPointsList.add(new NavigationPoint(701, 106, 27));
        mPointsList.add(new NavigationPoint(746, 106, 28));
        mPointsList.add(new NavigationPoint(837, 106, 29));
        mPointsList.add(new NavigationPoint(837, 236, 30));
        mPointsList.add(new NavigationPoint(740, 286, 31));
        mPointsList.add(new NavigationPoint(669, 352, 32));
        mPointsList.add(new NavigationPoint(725, 352, 33));
        mPointsList.add(new NavigationPoint(824, 352, 34));
        mPointsList.add(new NavigationPoint(955, 352, 35));
        mPointsList.add(new NavigationPoint(1119, 352, 36));



        mPointsDistanceList.add(new NavigationPointsDistance(1, 1, 2, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(2, 2, 3, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(3, 3, 4, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(4, 4, 5, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(5, 5, 6, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(6, 6, 7, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(7, 7, 8, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(8, 8, 9, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(9, 9, 10, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(10, 10, 11, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(11, 11, 12, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(12, 12, 13, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(13, 13, 14, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(14, 14, 15, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(15, 15, 16, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 15, 16, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 8, 17, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 17, 18, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 18, 19, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 19, 20, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 20, 21, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 21, 22, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 22, 23, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 23, 24, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 24, 25, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 25, 26, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 26, 27, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 27, 28, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 28, 29, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 29, 30, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 30, 31, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 31, 14, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 14, 32, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 32, 33, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 33, 34, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 34, 35, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 35, 29, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 35, 36, 1));
        mPointsDistanceList.add(new NavigationPointsDistance(16, 14, 32, 1));
//        mPointsDistanceList.add(new NavigationPointsDistance(16, 10, 17, 1));

        mPointsDirectionList.add(new NavigationPointsDirection(1, 0, 1, 2, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(2, 1, 2, 3, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(3, 2, 3, 4, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(4, 3, 4, 5, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(5, 4, 5, 6, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(6, 5, 6, 7, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(7, 6, 7, 8, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(8, 7, 8, 9, DirectionType.RIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(9, 8, 9, 10, DirectionType.LEFT));
        mPointsDirectionList.add(new NavigationPointsDirection(10, 9, 10, 11, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(11, 10, 11, 12, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(12, 11, 12, 13, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(13, 12, 13, 14, DirectionType.STRAIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(14, 13, 14, 15, DirectionType.RIGHT));
        mPointsDirectionList.add(new NavigationPointsDirection(15, 14, 15, 16, DirectionType.STRAIGHT));

//        Point[] points = {new Point(689, 510), new Point(764, 510) , new Point(764, 392), new Point(875, 392), new Point(875, 584), new Point(689, 574)};
//        mPolygons.add(new Polygon(1, points));
//        Point[] point1 = {new Point(689, 510), new Point(764, 510) , new Point(764, 392), new Point(875, 392), new Point(875, 584), new Point(689, 574)};
//        mPolygons.add(new Polygon(1, point1));
//        new Point(1,1);

        String[] polygonList = new String[]{
                "1, 114, 147, 186, 147, 186, 224, 115, 224"
                ,"2, 185, 147, 308, 147, 307, 224, 186, 224"
                ,"3, 308, 130, 379, 130, 379, 224, 308, 224"
                ,"4, 309, 83, 379, 84, 379, 130, 308, 130"
                ,"5, 307, 32, 451, 32, 451, 82, 308, 82"
                ,"6, 451, 33, 483, 33, 483, 82, 451, 82"
                ,"7, 483, 33, 530, 33, 530, 82, 483, 82"
                ,"8, 530, 33, 567, 33, 567, 82, 531, 82"
                ,"9, 568, 33, 614, 33, 614, 82, 567, 82"
                ,"10, 614, 32, 653, 33, 653, 82, 614, 82"
                ,"11, 654, 33, 855, 33, 855, 83, 653, 83"
        };

        for (String pointsList:
             polygonList) {

            Polygon mPolygon = convertToPolygon(pointsList);
            if (mPolygon!=null)
                mPolygons.add(mPolygon);


        }
    }

    public int getDistance(int pointId1, int pointId2){
        for (int i=0;i<mPointsDistanceList.size();i++){
            if (mPointsDistanceList.get(i).navigationPointId1==pointId1 || mPointsDistanceList.get(i).navigationPointId2==pointId1){
                if (mPointsDistanceList.get(i).navigationPointId1==pointId2 || mPointsDistanceList.get(i).navigationPointId2==pointId2){
                    return mPointsDistanceList.get(i).distance;
                }
            }
        }

        return 10000;
    }

    public Polygon convertToPolygon(String polygonPointsString){
        String ptsList[] = polygonPointsString.split(", ");
        if (ptsList.length>=7 && ptsList.length%2==1){
            Point[] pts = new Point[(ptsList.length-1)/2];
            for (int i = 1; i < ptsList.length; i+=2) {
                pts[((i+1)/2)-1] = new Point(Integer.valueOf(ptsList[i]), Integer.valueOf(ptsList[i+1]));
            }

            return new Polygon(Integer.valueOf(ptsList[0]), pts);
        }else{
            Log.d(TAG, "convertToPolygon: invalid points "+polygonPointsString);
        }
        return null;
    }


    public String points_string(){

        final String OBJECT_START = "{";
        final String OBJECT_END = "}";
        final String ARRAY_START = "[";
        final String ARRAY_END = "]";
        final String COLON = ":";
        final String QUOTES = "\"";
        StringBuffer pointsBuffer = new StringBuffer();

        pointsBuffer.append(OBJECT_START);
        pointsBuffer.append("\"points\"");
        pointsBuffer.append(COLON);
        pointsBuffer.append(ARRAY_START);
        pointsBuffer.append(OBJECT_START);

        pointsBuffer.append(OBJECT_END);
        pointsBuffer.append(ARRAY_END);
        pointsBuffer.append(OBJECT_END);
        return pointsBuffer.toString();
    }
}
