package com.alins.Util.HttpUtils;

import com.alins.Config.Ascii2dConfig;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Alin
 * @date 2023/1/23
 */
public class HttpHandleUtil {
    static String InitResponse;

    /**
     *
     * @return 返回ArrayList集合，保存图片URL
     * @throws IOException
     */
    public ArrayList SearchMapHandlePic() {
        Document parse = Jsoup.parse(InitResponse);

        Elements allImg = parse.select("img[loading]");

        ArrayList<String> selectImg = new ArrayList<>();

        final int searchNumber = Ascii2dConfig.INSTANCE.getSearchNumber();

        //存放查询到的完整的图片url
        for (int i = 1 ; i<searchNumber + 1 ; i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://ascii2d.net")
                    .append(allImg.get(i).attr("src"));
            selectImg.add(String.valueOf(stringBuilder));
        }
        return selectImg;
    }

    /**
     *
     * @return 返回为HashMap集合，保存图片出处和作者链接
     * @throws IOException
     */

    public ArrayList<String> SearchMapHandleAuthor() {
        Document parse = Jsoup.parse(InitResponse);

        Elements allInformation = parse.select("a[rel]");

        ArrayList<String> selectInformation = new ArrayList<>();

        final int searchNumber = Ascii2dConfig.INSTANCE.getSearchNumber();

        //存放作者以及图片信息
        for (int j = 0; j <searchNumber*2;j=j+2 ){
            String ComeFrom = allInformation.get(j+4).attr("href");
            String Author = allInformation.get(j+4+1).attr("href");
            selectInformation.add(ComeFrom);
            selectInformation.add(Author);
        }
        return selectInformation;
    }

    /**
     * @param url:请求链接
     * @return 返回未经处理的Response
     * @throws IOException
     */
    public HttpHandleUtil(String url) throws IOException {
        HttpsUtil httpsUtil = new HttpsUtil();
        InitResponse = httpsUtil.SearchMap2d(url);
    }
}
