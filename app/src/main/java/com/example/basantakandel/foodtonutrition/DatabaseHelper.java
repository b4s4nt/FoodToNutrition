package com.example.basantakandel.foodtonutrition;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "FoodNutrition.db";

    public static final String username = "username";
    public static final String email = "email";
    public static final String password = "password";
    public static final String signUpTableName = "Register";


    public static final String foodnames="foods";
    public static final String Energy="energy";
    public static final String Protein="protein";
    public static final String Carbohydrate="carbohydrate";
    public static final String Fat="fat";

    //    public static final String nutrientsQuantity="nutrientQuantity";
    public static final String nutritionTable = "nutrition";
    public static final String trackTable= "saveTable";
    //public static final String trackdate="trackdate";

    SQLiteDatabase db2;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


     db2=db;




//        //Signup Table
        String signUpTableCreationQuery = "create table if not exists " + signUpTableName + "(" +
                username + " text," +
                email + " text," +
                password + " text)";
        db.execSQL(signUpTableCreationQuery);

        String  nutritionTableCreate= "create table if not exists " + nutritionTable +" ("+
                foodnames + " text," +
                Energy + " text," +
                Protein + " text," +
                Carbohydrate + " text,"+
                Fat + " text)";
        db.execSQL(nutritionTableCreate);

        String  track= "create table if not exists " + trackTable +" ("+
                username + " text," +
                foodnames + " text," +
                Energy + " text," +
                Protein + " text," +
                Carbohydrate + " text,"+
                Fat + " text)";
           db.execSQL(track);




        db.execSQL("INSERT INTO "+nutritionTable  +" VALUES ('Snickers','220','4.0','29.0','40')");
//


        //Crumb Cake
        db.execSQL("INSERT INTO "+ nutritionTable + " VALUES ('Crumb Cake','200','2.00','24.0','10')");
//

        //Wai Wai

        db.execSQL("INSERT INTO "+ nutritionTable  +" VALUES ('WAIWAI','200','2.00','24.0','10')");
//

        //OREO MINI
        db.execSQL("INSERT INTO "+ nutritionTable  +" VALUES ('Oreo Mini','130','1.00','20.0','0')");

        db.execSQL("INSERT INTO "+ nutritionTable  +" VALUES ('Brocolli','340','28.2','66.4','37')");
//
        System.out.println("After Inserting the Data ");
//
    }


    public void dropTable(String tablename){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ tablename);




    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + signUpTableName);

        //Drop if exists
        db.execSQL("DROP TABLE IF EXISTS " + nutritionTable);

        onCreate(db);
    }

    public boolean insertIntoSignUpTable(String name, String  email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.username, name);
        contentValues.put(this. email, email);
        contentValues.put(this.password, password);
        long flag = db.insert(signUpTableName, null, contentValues);
        return flag != -1;
    }

    public int totalRowCountInTable(String tableName) {
        String countQuery = "SELECT  * FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public String getSpecificColumnValueOnMatching(String tableName, String matchingColumn, String equalsTo) {

        System.out.println(tableName+ matchingColumn+equalsTo);


        String returnValue = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from " + tableName + " where " +  matchingColumn + " = '" +equalsTo +"'", null);

        if (rs != null && rs.getCount() > 0) {
            rs.moveToFirst();
            returnValue = rs.getString(rs.getColumnIndex(DatabaseHelper.password));
            rs.close();
        }



        System.out.println("Here is Required Return Value:"+returnValue);
        return returnValue;
    }
    public String getSpecificColumnValueOnMatching2(String tableName, String matchingColumn, String equalsTo) {

        System.out.println(tableName+ matchingColumn+equalsTo);

        String returnValue = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from " + tableName + " where " +  matchingColumn + " = '" +equalsTo +"'", null);

        if (rs != null && rs.getCount() > 0) {
            rs.moveToFirst();
            returnValue = rs.getString(rs.getColumnIndex(DatabaseHelper.email));
            rs.close();
        }



        System.out.println("Here is Required Return Value:"+returnValue);
        return returnValue;
    }

    public List getAllUserNameFromDatabase() {
        List<String> usernameList= new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + signUpTableName +"", null);

        if (cursor != null && cursor.getCount() > 0) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                usernameList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.username)));
            }
            cursor.close();
        }

        return usernameList;
    }


    public List getSpecificNutritionOnMatching( String comparedTo) {


//        String returnValue = "";
        List<String> returnValue= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from " + nutritionTable + " where " +  foodnames + " = '" +comparedTo +"'", null);

        for (rs.moveToFirst(); !rs.isAfterLast(); rs.moveToNext()) {
            returnValue.add(rs.getString(1));
            returnValue.add(rs.getString(2));
            returnValue.add(rs.getString(3));
            returnValue.add(rs.getString(4));

        }

       System.out.println(Arrays.asList(returnValue));





        System.out.println("after calling  getSpecificNutritionOnMatching "+returnValue);

        return returnValue;
    }

    public List getAllFoodFromDatabase() {
        List<String> foodList= new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + nutritionTable +"", null);

        if (cursor != null && cursor.getCount() > 0) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                foodList.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.foodnames)));
            }
            cursor.close();
        }
        System.out.println(Arrays.asList(foodList));

        return foodList;
    }

    public Boolean insertIntoTrackTable(ArrayList<String> list) {

        System.out.println(Arrays.asList(list));

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(this.username,list.get(0));
        contentValues.put(this.foodnames, list.get(1));
        contentValues.put(this. Energy, list.get(2));
        contentValues.put(this.Protein, list.get(3));
        contentValues.put(this.Carbohydrate, list.get(4));
        contentValues.put(this.Fat, list.get(5));

        long flag = db.insert(trackTable, null, contentValues);

          return  flag!=-1;

    }


   public ArrayList<String>  getFromTrackTable(){

       ArrayList<String> list= new ArrayList<>();

       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery("select * from " + trackTable +"", null);

       if (cursor != null && cursor.getCount() > 0) {
           for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
               list.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.username)));
           }
           cursor.close();
       }
       System.out.println(Arrays.asList(list));

       return list;
   }


    public ArrayList<String>  getSpecificColOnMatching(String tableName, String matchingParameter, String equalsTo,int requiredColumn) {
        ArrayList<String> list= new ArrayList<>();

        System.out.println(tableName);
        System.out.println(matchingParameter);
        System.out.println(equalsTo);
        System.out.println(requiredColumn);



        //String returnValue = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from " + tableName + " where " +  matchingParameter + " = '" +equalsTo +"'", null);

        if (rs != null && rs.getCount() > 0) {
            for (rs.moveToFirst(); !rs.isAfterLast(); rs.moveToNext()) {
                list.add(rs.getString(requiredColumn));
                System.out.println(rs.getString(requiredColumn));

            }

            rs.close();
        }
        return list;
    }
}