import java.util.Arrays;
import static java.lang.System.out;
import static java.lang.Integer.parseInt;

public class Day2 {

    public static void main(String... args) {
        String input = "1224\t926\t1380\t688\t845\t109\t118\t88\t1275\t1306\t91\t796\t102\t1361\t27\t995\t" + "1928\t2097\t138\t1824\t198\t117\t1532\t2000\t1478\t539\t1982\t125\t1856\t139\t475\t1338\t" + "848\t202\t1116\t791\t1114\t236\t183\t186\t150\t1016\t1258\t84\t952\t1202\t988\t866\t" + "946\t155\t210\t980\t896\t875\t925\t613\t209\t746\t147\t170\t577\t942\t475\t850\t" + "1500\t322\t43\t95\t74\t210\t1817\t1631\t1762\t128\t181\t716\t171\t1740\t145\t1123\t" + "3074\t827\t117\t2509\t161\t206\t2739\t253\t2884\t248\t3307\t2760\t2239\t1676\t1137\t3055\t" + "183\t85\t143\t197\t243\t72\t291\t279\t99\t189\t30\t101\t211\t209\t77\t198\t" + "175\t149\t259\t372\t140\t250\t168\t142\t146\t284\t273\t74\t162\t112\t78\t29\t" + "169\t578\t97\t589\t473\t317\t123\t102\t445\t217\t144\t398\t510\t464\t247\t109\t" + "3291\t216\t185\t1214\t167\t495\t1859\t194\t1030\t3456\t2021\t1622\t3511\t222\t3534\t1580\t" + "2066\t2418\t2324\t93\t1073\t82\t102\t538\t1552\t962\t91\t836\t1628\t2154\t2144\t1378\t" + "149\t963\t1242\t849\t726\t1158\t164\t1134\t658\t161\t1148\t336\t826\t1303\t811\t178\t" + "3421\t1404\t2360\t2643\t3186\t3352\t1112\t171\t168\t177\t146\t1945\t319\t185\t2927\t2289\t" + "543\t462\t111\t459\t107\t353\t2006\t116\t2528\t56\t2436\t1539\t1770\t125\t2697\t2432\t" + "1356\t208\t5013\t4231\t193\t169\t3152\t2543\t4430\t4070\t4031\t145\t4433\t4187\t4394\t1754\t" + "5278\t113\t4427\t569\t5167\t175\t192\t3903\t155\t1051\t4121\t5140\t2328\t203\t5653\t3233";
        String[] nums = input.split("\t");
        int[] numArr = new int[16];
        int sum=0,sum2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            numArr[i % 16] = parseInt(nums[i]);
            if (numArr[15] != 0) {
                Arrays.sort(numArr);
                for (int a : numArr)
                    for (int b : numArr)
                        if (b % a == 0 && a != b)
                            sum2 += b / a;
                sum += numArr[15] - numArr[0];
                numArr = new int[16];
            }
        }
        out.printf("Part one: %s",sum);
        out.printf("Part two: %s",sum2);
    }
}
