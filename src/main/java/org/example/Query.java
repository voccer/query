package org.example;

public class Query {

	String[] querySimple = new String[10];
	String[] queryStatistical = new String[10];

	public Query() {

		// 10 câu truy vấn dạng đơn giản

		// query0: đưa thông tin toàn bộ liên quan về những country có label là: Senegal
		querySimple[0] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select ?c ?clabel ?cdesc ?clink ?cdate ?ccontinent\n"
				+ "where{\n"
				+ "?c :label ?clabel; \n"
				+ "   :description ?cdesc; \n"
				+ "   :link ?clink; \n"
				+ "   :date ?cdate; \n"
				+ "   :status ?ccontinent. \n"
				+ "filter regex(?clabel, \"Senegal\"). \n"
				+ "}\n";

		// query1: đưa ra thông tin mô tả về những person có label là: Adrianna Jacobson
		querySimple[1] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select ?p ?plabel ?pdesc\n"
				+ "where{ \n"
				+ "?p :label ?plabel; \n"
				+ "   :description ?pdesc. \n"
				+ "filter regex(?plabel, \"Adrianna Jacobson\"). \n"
				+ "}\n";

		// query2: đưa ra thông tin description về event có label : VietFood(label)
		querySimple[2] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select  ?e ?elabel ?edesc\n"
				+ "where{ \n"
				+ "?e :label ?elabel; \n"
				+ "   :description ?edesc. \n"
				+ "filter regex(?elabel, \"VietFood\")\n"
				+ "} ";

		// query3: đưa ra bao nhiêu country có label là: Việt Nam
		querySimple[3] = "prefix : <http://example.com/virtuoso#> \n" + "select count(?c) \n" + "where{ \n"
				+ "?c :label ?clabel. \n" + "filter regex(?clabel, \"Việt Nam\"). \n" + "} \n";

		// dua ra toan bo so relationship
		querySimple[4] = "prefix : <http://example.com/virtuoso#> \n" + "select count(?x) \n" + "where{\n"
				+ "?x ?r ?y. \n" + "filter regex(?r, \"Relationship#\"). \n" + "}\n";

		// dua ra toan bo thuc the
		querySimple[5] = "prefix : <http://example.com/virtuoso#> \n" + "select count(?x)\n" + "where{ \n"
				+ "?x :label ?xlabel. \n" + "}\n";

		// đưa ra thông tin mô tả các country có label là Thái Lan và có continent là
		// Châu á
		querySimple[6] = "prefix : <http://example.com/virtuoso#> \n" + "select ?c ?clabel ?ccontinent \n" + "where{ \n"
				+ "?c :label ?clabel; \n" + "   :status ?ccontinent. \n" + "filter regex(?clabel, \"Thái Lan\"). \n"
				+ "filter regex(?ccontinent, \"Châu Á\"). \n" + "} \n";

		// đưa ra trụ sở và thông tin của những tổ chức có chung label là: Siemens AG
		querySimple[7] = "prefix : <http://example.com/virtuoso#> \n" + "select ?o ?olabel ?odesc ?ohqt\n" + "where{ \n"
				+ "?o :label ?olabel; \n" + "   :description ?odesc; \n" + "   :headquarter ?ohqt. \n"
				+ "filter regex(?olabel, \"Siemens AG\"). \n" + "} \n";

		// đưa ra thông tin về location có id là Location198
		querySimple[8] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select distinct ?l ?llabel ?ldesc ?llink ?ldate \n" + "where{ \n" + "?l :label ?llabel; \n"
				+ "   :description ?ldesc; \n" + "   :link ?llink; \n" + "	  :date ?ldate. \n"
				+ "filter (?l= :Location198). \n" + "} \n";
		querySimple[9] = "prefix : <http://example.com/virtuoso#> \n" + "select distinct ?l\n" + "where{ \n"
				+ "?l :label ?llabel. \n"
				// + "filter(?clabel=\"Suriname\"^^xsd:string)."
				+ "filter regex(?l, \"Location\").\n" + "} \n" + "order by asc(str(?l))\n";

		// 10 câu truy vấn nâng cao

		// anh co quan he voi Location gi vao time Jun. 20, 2008
		// l la location
		// c la country
		queryStatistical[0] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select distinct ?c1 ?l1 ?t1 \n"
				+ "where{ \n" + "?c :label ?c1.\n" + "?t :label ?t1. \n" + "?l :label ?l1. \n"

				+ "?c ?r1 ?l. \n" + "?l ?r2 ?t. \n" + "filter regex(?c1, \"Anh\"). \n"
				+ "filter regex(?t1, \"Jun. 20, 2008\"). \n" + "filter regex(?l, \"Location\").\n" + "}\n";

		// Person Brodie Mathews có quan hệ với event nào ở Country: Togo
		queryStatistical[1] = "prefix : <http://example.com/virtuoso#> \n" + "select ?p1 ?c1 ?e1 \n" + "where{ \n"
				+ "?p :label ?p1.\n" + "?c :label ?c1.\n" + "?e :label ?e1. \n" + "?p ?r1 ?e .\n" + "?e ?r2 ?c. \n"
				+ "filter regex(?p1, \"Brodie Mathews\"). \n" + "filter regex(?c1, \"Sudan\") .\n"
				+ "filter regex(?e, \"Event\") .\n" + "}\n";

		// person Nikolas Miles đi bao nhiêu event ở Nam Mỹ
		queryStatistical[2] = "prefix : <http://example.com/virtuoso#> \n" + "select count(?e1)\n" + "where{ \n"
				+ "?p :label ?p1. \n" + "?e :label ?e1. \n" + "?c :status ?c1. \n" + "?p ?r1 ?e. \n" + "?e ?r2 ?c. \n"
				+ "filter regex(?p1, \" Nikolas Miles\"). \n" + "filter regex(?c1, \"Nam Mỹ\") .\n"
				+ "filter regex(?e, \"Event\") .\n" + "}\n";

		// Đưa ra toàn bộ thông tin về Country mà event VietWater describe
		queryStatistical[3] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select ?c ?clabel ?cdescription ?cdate ?ccontinent ?clink \n" + "where{ \n" + "?c :label ?clabel. \n"
				+ "?e :label ?elabel. \n" + "?c ?r ?e. \n" + "?c :description ?cdesc. \n"
				+ "?c :continent ?ccontinent. \n" + "?c :date ?cdate. \n" + "?c :link ?clink. \n"
				+ "filter regex(?elabel, \"VietWater\"). \n" + "filter regex(?r, \"describe\"). \n" + "}\n";

		// Đưa ra toàn bộ thông tin về Event mà country Armenia watch
		queryStatistical[4] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select ?e ?elabel ?edescription ?edate ?clink \n" 
				+ "where{ \n" 
				+ "?e :label ?elabel. \n"
				+ "?c :label ?clabel. \n"
				+ "?e ?r ?c. \n" 
				+ "?e :description ?edesc. \n"
				+ "?e :date ?edate. \n"
				+ "?e :link ?elink. \n"
				+ "filter regex(?clabel, \"Armenia\"). \n"
				+ "filter regex(?r, \"watch\"). \n"
				+ "}\n";
		

		// Đếm toàn bộ person tham gia watch với event là MTA Vietnam
		queryStatistical[5] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select count(?p)\n"
				+ "where{ \n"
				+ "?p ?r ?e. \n"
				+ "?e :label ?elabel. \n"
				+ "filter regex(?elabel, \"MTA Vietnam\"). \n"
				+ "filter regex(?r, \"watch\"). \n"
				+ "} \n";
		
		
		// Đếm số person có continent là Nam Cực và description là: She is a writer
		queryStatistical[6] = "prefix : <http://example.com/virtuoso#> \n"
				+ "select count(?p) \n"
				+ "where{ \n"
				+ "?p ?r ?c. \n"
				+ "?c :continent ?ccontinent. \n"
				+ "?p :description ?pdesc. \n"
			//	+ "filter regex(?ccontinent, \"Nam Cực\"). \n"
				+ "filter regex(?pdesc, \"She is a writer\"). \n"
				+ "} \n";
		queryStatistical[7] = "";
		queryStatistical[8] = "";
		queryStatistical[9] = "";

	}

}
