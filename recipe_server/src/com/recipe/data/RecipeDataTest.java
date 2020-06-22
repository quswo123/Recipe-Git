package com.recipe.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RecipeDataTest  {
   /**
    * 특정 URL에 요청을 전송하고, 응답 데이터를 반환한다
    * @param requestURL 요청변수를 포함한 URL
    * @return 응답받은 데이터
    */
   public static String requestData(String requestURL) {
      BufferedReader br = null;
      String read, result = "";
      try {
         URL url = new URL(requestURL);
         br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
         while((read = br.readLine()) != null) result += read;
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if(br != null) {
            try {
               br.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
      
      return result;
   }
   
   /**
    * 특정 URL에 요청을 전송하여 응답받은 데이터를 파싱하여 반환한다
    * @param requestURL 요청변수를 포함한 URL
    * @param api_url api서버의 디렉토리 url
    * @return 파싱한 데이터
    */
   public static JSONArray getJSON(String requestURL, String api_url) {
      String data = requestData(requestURL);
      
      JSONParser parser = new JSONParser();
      JSONObject temp = null;
      try {
         temp = (JSONObject) ((JSONObject)parser.parse(data)).get(api_url);
      } catch (ParseException e) {
         e.printStackTrace();
      }
      JSONArray result = (JSONArray) temp.get("row");
      
      return result;
   }
   
   /**
    * api 서버에서 레시피 기본정보 데이터를 가져온다
    * @return 레시피 기본정보 데이터
    */
   public static JSONArray requestBasicInfo() {
      JSONArray result = new JSONArray();
      try {
         String api_key = "/"
               + URLEncoder.encode("ed5a94e3d628469b67e53aa2cb74b90bf955f521aeb19532f0fbe77f11762752", "UTF-8");
         String type = "/" + URLEncoder.encode("json", "UTF-8");
         // 레시피 기본정보 요청 URL
         String api_url_basic_info = "/" + URLEncoder.encode("Grid_20150827000000000226_1", "UTF-8");
         
         //한번의 요청에 최대 1000개의 데이터를 가져올 수 있기때문에, 1000개씩 나누어서 데이터를 가져온다
         int i = 0;
         while (true) {
            int start = 1000*i + 1;
            int end = 1000*(i+1);
            String start_index = "/" + URLEncoder.encode(Integer.toString(start), "UTF-8");
            String end_index = "/" + URLEncoder.encode(Integer.toString(end), "UTF-8");
            String requestURL = "http://211.237.50.150:7080/openapi" + api_key + type + api_url_basic_info
                  + start_index + end_index;
            JSONArray temp = getJSON(requestURL, "Grid_20150827000000000226_1");
            if(temp.isEmpty()) break;
            result.addAll(temp);
            i++;
         }
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
      return result;
   }
   
   /**
    * api 서버에서 레시피 재료정보 데이터를 가져온다
    * @return 레시피 재료정보 데이터
    */
   public static JSONArray requestIngredientsInfo() {
      JSONArray result = new JSONArray();
      try {
         String api_key = "/"
               + URLEncoder.encode("ed5a94e3d628469b67e53aa2cb74b90bf955f521aeb19532f0fbe77f11762752", "UTF-8");
         String type = "/" + URLEncoder.encode("json", "UTF-8");
         //레시피 재료정보 요청 URL
         String api_url_ingredients = "/" + URLEncoder.encode("Grid_20150827000000000227_1", "UTF-8");
         
         //한번의 요청에 최대 1000개의 데이터를 가져올 수 있기때문에, 1000개씩 나누어서 데이터를 가져온다
         int i = 0;
         while (true) {
            int start = 1000*i + 1;
            int end = 1000*(i+1);
            String start_index = "/" + URLEncoder.encode(Integer.toString(start), "UTF-8");
            String end_index = "/" + URLEncoder.encode(Integer.toString(end), "UTF-8");
            String requestURL = "http://211.237.50.150:7080/openapi" + api_key + type + api_url_ingredients
                  + start_index + end_index;
            JSONArray temp = getJSON(requestURL, "Grid_20150827000000000227_1");
            if(temp.isEmpty()) break;
            result.addAll(temp);
            i++;
         }
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
      return result;
   }
   
   /**
    * api 서버에서 레시피 과정정보 데이터를 가져온다
    * @return 레시피 과정정보 데이터
    */
   public static JSONArray requestRecipeInfo() {
      JSONArray result = new JSONArray();
      try {
         String api_key = "/"
               + URLEncoder.encode("ed5a94e3d628469b67e53aa2cb74b90bf955f521aeb19532f0fbe77f11762752", "UTF-8");
         String type = "/" + URLEncoder.encode("json", "UTF-8");
         //레시피 과정정보 요청 URL
         String api_url_recipe_info = "/" + URLEncoder.encode("Grid_20150827000000000228_1", "UTF-8");
         
         //한번의 요청에 최대 1000개의 데이터를 가져올 수 있기때문에, 1000개씩 나누어서 데이터를 가져온다
         int i = 0;
         while (true) {
            int start = 1000*i + 1;
            int end = 1000*(i+1);
            String start_index = "/" + URLEncoder.encode(Integer.toString(start), "UTF-8");
            String end_index = "/" + URLEncoder.encode(Integer.toString(end), "UTF-8");
            String requestURL = "http://211.237.50.150:7080/openapi" + api_key + type + api_url_recipe_info
                  + start_index + end_index;
            JSONArray temp = getJSON(requestURL, "Grid_20150827000000000228_1");
            if(temp.isEmpty()) break;
            result.addAll(temp);
            i++;
         }
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
      return result;
   }
   
   /**
    * 레시피 정보 테이블 recipe_info에 데이터를 입력한다
    * @param basicInfo api로 가져온 레시피 기본정보 데이터
    * @param recipeInfo api로 가져온 레시피 과정정보 데이터
    */
   public static void insertBasicInfo(JSONArray basicInfo, JSONArray recipeInfo) {
      for(Object i : basicInfo) {
         JSONObject iObj = (JSONObject) i;
         String recipeSumm = iObj.get("SUMRY").toString(); //recipe 요약
         String recipeName = iObj.get("RECIPE_NM_KO").toString(); //recipe 이름
         String strPrice = iObj.get("PC_NM").toString().replaceAll(",", "");
         int recipePrice; //recipe 가격 추출
         try {
            recipePrice = Integer.parseInt(strPrice.substring(0, strPrice.length() - 1));
         } catch (StringIndexOutOfBoundsException e) {
            recipePrice = (int)(30000 * Math.random());
         }
         int recipeCode = Integer.parseInt(iObj.get("RECIPE_ID").toString());
         String recipeProcess = ""; //레시피 과정 추출
         for(Object j : recipeInfo) { //recipe id별로 과정을 추출하기 위해 과정 정보의 모든 행을 검색하여 일치하는 recipe id의 과정을 recipeProcess 문자열에 더한다
            JSONObject jObj = (JSONObject) j;
            int jId = Integer.parseInt(jObj.get("RECIPE_ID").toString());
            if(recipeCode == jId) {
               int process_num = Integer.parseInt(jObj.get("COOKING_NO").toString());
               recipeProcess += process_num + ". " + jObj.get("COOKING_DC").toString() + "\n";
            }
         }

         //레시피 과정정보를 레시피코드별로 파일 생성
         String recipeProcessFilePath = "c:/kostaProjects/recipeData/recipeProcess/" + recipeCode + ".txt";
         File recipeProcessFile = new File(recipeProcessFilePath);
         BufferedWriter bw = null;
         try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(recipeProcessFile)));
            bw.write(recipeProcess);
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            if(bw != null) {
               try {
                  bw.close();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         }
         
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String oracle_id = "recipe";
         String oracle_pwd = "recipe";
         
         try {
            String query = "INSERT INTO recipe_info (recipe_code, recipe_name, recipe_summ, recipe_price, recipe_process, rd_id) VALUES (?, ?, ?, ?, ?, ?)";
            conn = DriverManager.getConnection(url, oracle_id, oracle_pwd); //JDBC를 이용하여 oracle database에 connection을 생성
            stmt = conn.prepareStatement(query); //SQL문을 깔끔하게 생성하기 위한 PreparedStatement 생성. SQL문을 작성한 문자열에 ?을 포함하면 매개변수처럼 처리가 가능
            stmt.setInt(1, recipeCode);
            stmt.setString(2, recipeName);
            stmt.setString(3, recipeSumm);
            stmt.setInt(4, recipePrice);
            stmt.setString(5,  recipeProcessFilePath);
            String rdId = "id" + (int)(10 * Math.random()); //레시피를 작성한 R&D를 무작위로 입력 (샘플 데이터로 R&D 테이블에 'id0' ~ 'id9'의 행을 입력해두었음)
            stmt.setString(6, rdId);

            rs = stmt.executeQuery(); //위에서 생성한 쿼리문을 실행
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            if(rs != null) {
               try {
                  rs.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if(stmt != null) {
               try {
                  stmt.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if(conn != null) {
               try {
                  conn.close(); //connection(session)을 닫으면 자동으로 commit 처리됨
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            try {
               //connection을 close하는 속도보다 새로운 connection을 생성하는 속도가 더 빨라서 db에 너무 많은 연결이 생성되는 현상이 발생했다. 
               //이를 해결하기 위해 각 connection 생성에 약간의 시간차를 두도록 하였다.
               Thread.sleep(50);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
   
   /**
    * 재료 테이블 ingredient와 레시피 재료 테이블 recipe_ingredient에 데이터를 입력
    * @param ingredientsInfo api로 가져온 데이터(JSONArray)
    */
   public static void insertIngredientsInfo(JSONArray ingredientsInfo) {
      for(Object i : ingredientsInfo) {
         JSONObject obj = (JSONObject)i;
         int ingCode = Integer.parseInt(obj.get("IRDNT_SN").toString()); // 재료코드 추출
         String ingName = obj.get("IRDNT_NM").toString(); // 재료 이름
         String ingSize = obj.get("IRDNT_CPCTY").toString(); //재료 용량
         int recipeCode = Integer.parseInt(obj.get("RECIPE_ID").toString()); //레시피 코드 추출
         
         Connection conn = null;
         PreparedStatement stmt1 = null, stmt2 = null, stmt3 = null;
         ResultSet rs1 = null, rs2 = null, rs3 = null;
         
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String oracle_id = "recipe";
         String oracle_pwd = "recipe";
         String query;
         try {
            query = "INSERT INTO ingredient (ing_code, ing_name, ing_size) VALUES (?, ?, ?)";
            conn = DriverManager.getConnection(url, oracle_id, oracle_pwd);
            stmt1 = conn.prepareStatement(query);
            stmt1.setInt(1, ingCode);
            stmt1.setString(2, ingName);
            stmt1.setString(3, ingSize);
            
            rs1 = stmt1.executeQuery();
            
            query = "INSERT INTO recipe_ingredient (recipe_code, ing_code) VALUES (?, ?)";
            stmt2 = conn.prepareStatement(query);
            stmt2.setInt(1, recipeCode);
            stmt2.setInt(2, ingCode);
            
            rs2 = stmt2.executeQuery();
            
            
         } catch (SQLException e) {
            //레시피 정보에는 없는데 재료에만 있는 재료 정보들을 삭제
            query = "DELETE ingredient WHERE ing_code = " + ingCode;
            try {
               stmt3 = conn.prepareStatement(query);
               
               rs3 = stmt3.executeQuery();
            } catch (SQLException e1) {
               e1.printStackTrace();
            }
         } finally {
            if(rs1 != null) {
               try {
                  rs1.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if(rs2 != null) {
               try {
                  rs2.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if(rs3 != null) {
               try {
                  rs3.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if(stmt1 != null) {
               try {
                  stmt1.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if(stmt2 != null) {
               try {
                  stmt2.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if(stmt3 != null) {
               try {
                  stmt3.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if(conn != null) {
               try {
                  conn.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            
            try {
               Thread.sleep(40);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
   
   public static void main(String[] args) {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver"); //JDBC 사용을 위한 oracle driver 로드
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      JSONArray basicInfo = requestBasicInfo();
      JSONArray ingredientsInfo = requestIngredientsInfo();
      JSONArray recipeInfo = requestRecipeInfo();
      
      insertBasicInfo(basicInfo, recipeInfo);
      insertIngredientsInfo(ingredientsInfo);
   }
}
