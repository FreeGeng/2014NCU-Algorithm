package com.example.lookforcoffee;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LookForCoffee extends ActionBarActivity implements
		LocationListener {

	private Spinner citySpinner;
	private Spinner districtSpinner;
	
	//-----------------------------------------------------------------------------------
	// city
	private String[] city = { "基隆市", "台北市", "新北市", "大桃園", "新竹市", "新竹縣", "苗栗縣",
			"大台中", "南投縣", "彰化縣", "雲林縣", "嘉義縣", "嘉義市", "大台南", "大高雄", "屏東縣",
			"台東縣", "花蓮縣", "宜蘭縣" };
	private ArrayAdapter<String> cityList;
	//-----------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------
	// district
	private String[][] district = {
			{ "仁愛區", "中正區", "信義區", "中山區", "安樂區", "七堵區", "暖暖區" },

			{ "中正區", "大同區", "中山區", "松山區", "大安區", "萬華區", "信義區", "士林區", "北投區",
					"內湖區", "南港區", "文山區" },

			{ "板橋區", "三重區", "中和區", "新莊區", "永和區", "土城區", "樹林區", "三峽區", "鶯歌區",
				    "蘆洲區", "五股區", "泰山區", "林口區", "淡水區", "金山區", "八里區",
					"萬里區", "石門區", "三芝區", "瑞芳區", "汐止區", "平溪區", "貢寮區", "雙溪區",
					"深坑區", "石碇區", "新店區", "坪林區", "烏來區" },

			{ "桃園市", "八德市", "大溪鎮", "蘆竹市", "龜山鄉", "大園鄉", "中壢市", "龍潭鄉", "平鎮市",
					"楊梅市", "新屋鄉", "觀音鄉", "復興鄉" },

			{ "北區", "東區", "香山區" },

			{ "竹北市", "竹東鎮", "新埔鎮", "關西鎮", "新豐鄉", "峨眉鄉", "寶山鄉", "五峰鄉", "橫山鄉",
					"北埔鄉", "尖石鄉", "芎林鄉", "湖口鄉" },
			{ "苗栗市", "通霄鎮", "苑裡鎮", "西湖鄉", "頭屋鄉", "公館鄉", "銅鑼鄉", "三義鄉", "竹南鎮",
					"頭份鎮", "後龍鎮", "造橋鄉", "三灣鄉", "南庄鄉", "大湖鄉", "卓蘭鎮", "獅潭鄉",
					"泰安鄉" },
			{ "中區", "東區", "南區", "西區", "北區", "北屯區", "西屯區", "南屯區", "太平區", "大里區",
					"霧峰區", "烏日區", "豐原區", "后里區", "石岡區", "東勢區", "和平區", "新社區",
					"潭子區", "大雅區", "神岡區", "大肚區", "沙鹿區", "龍井區", "梧棲區", "清水區",
					"大甲區", "外埔區", "大安區" },
			{ "南投市", "埔里鎮", "草屯鎮", "竹山鎮", "集集鎮", "名間鄉", "鹿谷鄉", "中寮鄉", "魚池鄉",
					"國姓鄉", "水里鄉", "信義鄉", "仁愛鄉" },
			{ "彰化市", "員林鎮", "和美鎮", "鹿港鎮", "溪湖鎮", "二林鎮", "田中鎮", "北斗鎮", "花壇鄉",
					"芬園鄉", "大村鄉", "永靖鄉", "伸港鄉", "線西鄉", "福興鄉", "秀水鄉", "埔心鄉",
					"埔鹽鄉", "大城鄉", "芳苑鄉", "竹塘鄉", "社頭鄉", "二水鄉", "田尾鄉", "埤頭鄉",
					"溪州鄉" },
			{ "斗六市", "林內鄉", "斗南鎮", "古坑鄉", "大埤鄉", "莿桐鄉", "虎尾鎮", "西螺鎮", "土庫鎮",
					"褒忠鄉", "二崙鄉", "崙背鄉", "麥寮鄉", "臺西鄉", "東勢鄉", "北港鎮", "元長鄉",
					"四湖鄉", "口湖鄉", "水林鄉" },
			{ "太保市", "朴子市", "布袋鎮", "大林鎮", "民雄鄉", "溪口鄉", "新港鄉", "六腳鄉", "東石鄉",
					"義竹鄉", "鹿草鄉", "水上鄉", "中埔鄉", "竹崎鄉", "梅山鄉", "番路鄉", "大埔鄉",
					"阿里山鄉" },
			{ "東區", "西區" },
			{ "中西區", "東區", "南區", "北區", "安平區", "安南區", "永康區", "歸仁區", "新化區",
					"左鎮區", "玉井區", "楠西區", "南化區", "仁德區", "關廟區", "龍崎區", "官田區",
					"麻豆區", "佳里區", "西港區", "七股區", "將軍區", "學甲區", "北門區", "新營區",
					"後壁區", "白河區", "東山區", "六甲區", "下營區", "柳營區", "鹽水區", "善化區",
					"大內區", "山上區", "新市區", "安定區" },
			{ "楠梓區", "左營區", "鼓山區", "三民區", "鹽埕區", "前金區", "新興區", "苓雅區", "前鎮區",
					"旗津區", "小港區", "鳳山區", "大寮區", "鳥松區", "林園區", "仁武區", "大樹區",
					"大社區", "岡山區", "路竹區", "橋頭區", "梓官區", "彌陀區", "永安區", "燕巢區",
					"田寮區", "阿蓮區", "茄萣區", "湖內區	", "旗山區", "美濃區", "內門區", "杉林區",
					"甲仙區", "六龜區", "茂林區", "桃源區", "那瑪夏區" },
			{ "屏東市", "萬丹鄉", "長治鄉", "麟洛鄉", "九如鄉", "里港鄉", "鹽埔鄉", "高樹鄉", "霧台鄉",
					"三地門鄉", "潮州鎮", "萬巒鄉", "竹田鄉", "泰武鄉", "內埔鄉", "新埤鄉", "瑪家鄉",
					"來義鄉", "枋寮鄉", "枋山鄉", "春日鄉", "獅子鄉", "東港鎮", "新園鄉", "崁頂鄉",
					"林邊鄉", "南州鄉", "佳冬鄉", "琉球鄉", "恆春鎮", "車城鄉", "滿州鄉", "牡丹鄉" },
			{ "臺東市", "成功鎮", "關山鎮", "長濱鄉", "海端鄉", "池上鄉", "東河鄉", "鹿野鄉", "延平鄉",
					"卑南鄉", "金峰鄉", "大武鄉", "達仁鄉", "綠島鄉", "蘭嶼鄉", "太麻里鄉" },
			{ "花蓮市", "新城鄉", "吉安鄉", "壽豐鄉", "秀林鄉", "鳳林鎮", "光復鄉", "豐濱鄉", "瑞穗鄉",
					"萬榮鄉", "玉里鎮", "富里鄉", "卓溪鄉" },
			{ "宜蘭市", "頭城鎮", "礁溪鄉", "壯圍鄉", "員山鄉", "羅東鎮", "五結鄉", "三星鄉", "冬山鄉",
					"大同鄉", "蘇澳鎮", "南澳鄉" },

	};
	private ArrayAdapter<String> districtList;
	//-----------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------
	// 經緯度
	double[][][] lat_long = 
		{
			{//基隆市
				{25.118716,121.745193},{25.148999,121.773682},{25.128434,121.782228},{25.152587,121.725246},{25.147414,121.702445},
				{25.114392,121.685341},{25.083616,121.748042}
			},
			{//台北市
				{25.042141,121.519872},{25.062724,121.511306},{25.079202,121.542709},{25.055296,121.554126},{25.026158,121.542709},
				{25.026286,121.497029},{25.028702,121.576957},{25.095049,121.524608},{25.115176,121.515018},{25.068942,121.590903},
				{25.031235,121.611195},{24.992921,121.571250}
			},
			{//新北市
				{25.011409,121.461841},{25.061453,121.486711},{24.996218,121.485310},{25.026598,121.417835},{25.010325,121.514535},
				{24.968371,121.438034},{24.981561,121.419861},{24.935861,121.374490},{24.961497,121.342726},{25.086891,121.471524},
				{25.084832,121.438659},{25.058164,121.432792},{25.079011,121.388138},{25.171981,121.443371},{25.225080,121.638625},
				{25.144390,121.398302},{25.167602,121.639718},{25.290828,121.567138},{25.259345,121.502434},{25.103052,121.822098},
				{25.061606,121.639718},{25.024831,121.740865},{25.016876,121.945979},{24.997184,121.822098},{25.003379,121.616900},
				{25.009866,121.645283},{24.978282,121.539482},{24.935084,121.710761},{24.866372,121.549780}
			},
			{//大桃園
				{24.993410,121.296967},{24.946906,121.291246},{24.868722,121.285887},{25.088499,121.287399},{25.019909,121.365599},
				{25.049263,121.193945},{24.972151,121.205396},{24.844493,121.205396},{24.929602,121.205396},{24.924211,121.136672},
				{24.982660,121.067907},{25.035936,121.113754},{24.712120,121.360400}
			},
			{//新竹市
				{24.819450,120.962553},{24.783496,121.011195},{24.797225,120.942735}
			},
			{//新竹縣
				{24.834687,120.993368},{24.774922,121.044977},{24.826826,121.067390},{24.804485,121.148128},{24.900594,120.988037},
				{24.678841,120.999103},{24.742791,120.999103},{24.591544,121.148128},{24.711301,121.136672},{24.778289,120.988108},
				{}
			}
		};
	//-----------------------------------------------------------------------------------

	//-----------------------------------------------------------------------------------
	// google map
	//webview的初始頁面
	private static final String MAP_URL = "file:///android_asset/googlemap.html";
	private WebView webView;
	private boolean webviewReady = false;
	private Location mostRecentLocation = null;
	private EditText LatText, LogText;
	//-----------------------------------------------------------------------------------

	private void getLocation() {// 取得裝置的GPS位置資料
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		String provider = locationManager.getBestProvider(criteria, true);
		// In order to make sure the device is getting the location, request
		// updates.
		locationManager.requestLocationUpdates(provider, 1, 0, this);
		mostRecentLocation = locationManager.getLastKnownLocation(provider);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);

		citySpinner = (Spinner) findViewById(R.id.spinner1);
		districtSpinner = (Spinner) findViewById(R.id.spinner2);
		Button button1 = (Button) findViewById(R.id.button1);
		LatText = (EditText) findViewById(R.id.editText1);
		LogText = (EditText) findViewById(R.id.editText2);

		// textview1是指派給spinner使用的一個layout
		cityList = new ArrayAdapter<String>(this, R.layout.textview1, city);
		// 設定下拉選單的樣式
		cityList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		citySpinner.setAdapter(cityList);

		citySpinner
				.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView adapterView,
							View view, int position, long id) {
						Toast.makeText(
								LookForCoffee.this,
								"您選擇"
										+ adapterView.getSelectedItem()
												.toString(), Toast.LENGTH_LONG)
								.show();

						districtList = new ArrayAdapter<String>(
								LookForCoffee.this, R.layout.textview2,
								district[position]);
						districtList
								.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						districtSpinner.setAdapter(districtList);

						
					}

					@Override
					public void onNothingSelected(AdapterView arg0) {
						Toast.makeText(LookForCoffee.this, "您沒有選擇任何項目",
								Toast.LENGTH_LONG).show();
					}
				});

		districtSpinner
				.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						
//						Toast.makeText(
//								LookForCoffee.this,
//								"您選擇"
//										+ parent.getSelectedItem()
//												.toString(), Toast.LENGTH_LONG)
//								.show();
//						
//						int cityposition = citySpinner.getSelectedItemPosition();
//						final String centerURL = "javascript:centerAt("
//								+ lat_long[cityposition][position] + ","
//								+ lat_long[cityposition][position] + ")";
//						webView.loadUrl(centerURL);
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
				});

		button1.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub

				if (webviewReady) {
					// 由輸入的經緯度值標註在地圖上，呼叫在googlemaps.html中的mark函式
					final String markURL = "javascript:mark("
							+ LatText.getText() + "," + LogText.getText() + ")";
					webView.loadUrl(markURL);

					 //畫面移至標註點位置，呼叫在googlemaps.html中的centerAt函式
					final String centerURL = "javascript:centerAt("
							+ LatText.getText() + "," + LogText.getText() + ")";
					webView.loadUrl(centerURL);
				}

			}
		});
		
		getLocation();// 取得定位位置
		setupWebView();// 設定webview
		if (mostRecentLocation != null) {
			LatText.setText("" + mostRecentLocation.getLatitude());
			LogText.setText("" + mostRecentLocation.getLongitude());

			// 將畫面移至定位點的位置
			final String centerURL = "javascript:centerAt("
					+ mostRecentLocation.getLatitude() + ","
					+ mostRecentLocation.getLongitude() + ")";
			if (webviewReady)
				webView.loadUrl(centerURL);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.look_for_coffee, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/** Sets up the WebView object and loads the URL of the page **/
	private void setupWebView() {

		webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
		// Wait for the page to load then send the location information
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				// webView.loadUrl(centerURL);
				webviewReady = true;// webview已經載入完畢
			}

		});
		webView.loadUrl(MAP_URL);
	}

	@Override
	public void onLocationChanged(Location location) {// 定位位置改變時會執行的方法
		// TODO Auto-generated method stub
		// if (location != null) {
		// LatText.setText("" + location.getLatitude());
		// LogText.setText("" + location.getLongitude());
		// // 將畫面移至定位點的位置，呼叫在googlemaps.html中的centerAt函式
		// final String centerURL = "javascript:centerAt("
		// + location.getLatitude() + "," + location.getLongitude()
		// + ")";
		// if (webviewReady)
		// webView.loadUrl(centerURL);
		// }
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
}
