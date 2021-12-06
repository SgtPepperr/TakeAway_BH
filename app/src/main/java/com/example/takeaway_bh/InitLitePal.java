package com.example.takeaway_bh;

import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.Bean.User;

public class InitLitePal {

    public void init() {
        setUser("123456", "123456", false);
        setStore("学二食堂", R.drawable.apple_pic, "地处北航黄金地段，位于培训中心西侧建筑物的一楼，然而楼上的教工食堂才是最物美价廉的（狗头");
        setStore("学五食堂", R.drawable.banana_pic, "这是一个不错的食堂");
        setGood("麻婆豆腐", "麻婆豆腐，是四川省传统名菜之一，属于川菜，，此菜成菜麻、辣、鲜、香、烫、翠、嫩、酥，将川菜麻辣味型的特点展现的淋漓尽致",
                "学二食堂", R.drawable.ma_po_dou_fu, 6);
        setGood("西红柿炒鸡蛋", "西红柿炒鸡蛋是以西红柿，鸡蛋为主料制作的家常菜。味道咸香可口，特别下饭。",
                "学二食堂", R.drawable.xi_hong_shi_chao_ji_dan, Float.parseFloat("6.5"));
        setGood("番茄炖牛腩", "番茄炖牛腩具有清热止咳、养阴凉血、延缓衰老之功效。",
                "学二食堂", R.drawable.fan_qie_dun_niu_nan, 12);
        setGood("干锅兔", "干锅兔是一道以兔子、藕、姜等为主要食材制作的川菜。",
                "学二食堂", R.drawable.gan_guo_tu, Float.parseFloat("9.5"));
        setGood("小葱拌豆腐", "小葱拌豆腐是一道很普通的家常小菜。很多人喜欢吃。其特点色泽素雅淡洁，清香飘逸，鲜嫩爽口。",
                "学二食堂", R.drawable.xiao_cong_ban_dou_fu, 4);
        setGood("青椒肉丝", "青椒肉丝，是以青椒为主要食材的家常菜，属于川菜菜系。口味香辣，菜品色香味俱全，操作简单，营养价值丰富。",
                "学二食堂", R.drawable.qing_jao_rou_si, 8);
        setGood("宫保鸡丁", "宫保鸡丁选用鸡肉为主料，佐以花生米、辣椒等辅料烹制而成；红而不辣、辣而不猛、香辣味浓、肉质滑脆；其入口鲜辣，鸡肉的鲜嫩可以配合花生的香脆。",
                "学五食堂", R.drawable.gong_bao_ji_ding, 8);
        setGood("红烧茄子", "红烧茄子是一道历史久远的汉族传统佳肴，此菜是素菜中的精细者。鲜香适口，外酥里嫩，味美多汁，大众食品。",
                "学五食堂", R.drawable.hong_shao_qie_zi, 6);
        setGood("鱼香肉丝", "鱼香肉丝是一道著名川菜，其咸鲜酸甜兼备，葱姜蒜香浓郁，其味是调味品调制而成，此法源出于四川民间独具特色的烹鱼调味方法，而今已广泛用于川味的熟菜中。",
                "学五食堂", R.drawable.yu_xiang_rou_si, 8);
        setGood("山药炖排骨", "山药炖排骨作为冬季一道滋补药膳，排骨中富含血红素铁，而且还富含优质蛋白质，山药中富含可溶性膳食纤维，可以帮助矿物质的吸收，也可以帮助维持肠道健康，预防便秘。",
                "学五食堂", R.drawable.shan_yao_dun_pai_gu, 10);
        setGood("莴笋炒肉", "莴笋炒肉是一道很好吃的家常菜，此菜咸香宜人，口感清脆。莴笋肉质细嫩，生吃热炒均相宜。",
                "学五食堂", R.drawable.wo_sun_chao_rou, 8);
        setGood("蚝油生菜", "蚝油生菜利用生菜及蚝油配以辅料加工炒制而成，该菜营养丰富，鲜嫩可口、清鲜润滑。",
                "学五食堂", R.drawable.hao_you_sheng_cai, 4);
        setGood("酸辣土豆丝", "酸辣土豆丝，是用土豆、辣椒、白醋，葱，姜等制作而成的菜肴，色泽光亮，酸辣可口。",
                "学五食堂", R.drawable.suan_la_tu_dou_si, Float.parseFloat("4.5"));
    }

    public void setUser(String name, String password, Boolean b) {
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setRider(b);
        user.save();
    }

    public void setStore(String name, int image, String intro) {
        Store store = new Store();
        store.setStoreName(name);
        store.setImageId(image);
        store.setIntroduction(intro);
        store.save();
    }

    public void setGood(String name, String intro, String storeName, int image, float price) {
        Good good = new Good();
        good.setName(name);
        good.setIntroduction(intro);
        good.setStoreName(storeName);
        good.setImageId(image);
        good.setPrice(price);
        good.save();
    }
}
