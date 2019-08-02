package NowCoder;
import java.util.*;
public class Main9 {
    /**
     * 人民币转换
     * 考试题目和要点：
     * 1、中文大写金额数字前应标明“人民币”字样。
     * 中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填 写。（30分）
     * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
     * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元 壹角肆分“。（
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String result = "人民币";
            String string = sc.nextLine();
            String[] arrs = string.split("\\.");
            // 小数点前
            // 看是否有亿级
            if (arrs[0].length() <= 4)// XXXX级别
                result = result + toCNsentence(arrs[0]);
            else if (arrs[0].length() > 4 && arrs[0].length() <= 8) {// XXXX,XXXX级别
                String str1 = arrs[0].substring(0, arrs[0].length() - 4);
                String str2 = arrs[0].substring(arrs[0].length() - 4);
                result = result + toCNsentence(str1) + "万" + toCNsentence(str2);
            } else {// XXXX,XXXX,XXXX级别
                String str1 = arrs[0].substring(0, arrs[0].length() - 8);
                String str2 = arrs[0].substring(arrs[0].length() - 8, arrs[0].length() - 4);
                String str3 = arrs[0].substring(arrs[0].length() - 4);
                result = result + toCNsentence(str1) + "亿" + toCNsentence(str2) + "万" + toCNsentence(str3);
            }
            // 整数分析完后价格个元
            if(result.charAt(result.length()-1)!='币')
                result = result + "元";
            // 小数点后
            if (arrs[1].charAt(0) == '0' && arrs[1].charAt(1) == '0')
                result = result + "整";
            else if (arrs[1].charAt(0) == '0' && arrs[1].charAt(1) != '0')
                result = result + toCNword(arrs[1].charAt(1)) + "分";
            else if (arrs[1].charAt(0) != '0' && arrs[1].charAt(1) == '0') {
                result = result + toCNword(arrs[1].charAt(0)) + "角";
            } else {
                result = result + toCNword(arrs[1].charAt(0)) + "角" + toCNword(arrs[1].charAt(1)) + "分";
            }
            System.out.println(result);
        }
    }

    private static String toCNsentence(String str) {
        String result = "";
        if (str.length() == 1) {
            if(str.charAt(0)!='0')result = toCNword(str.charAt(0));
        }
        if (str.length() == 2)// 30 25 10 15几种情况
        {
            if (str.charAt(0) == '1')
                result = result + "拾";
            else
                result = result + toCNword(str.charAt(0)) + "拾";
            if (str.charAt(1) != '0')
                result = result + toCNword(str.charAt(1));
        }
        if (str.length() == 3)// 300 301 315
        {
            result = result + toCNword(str.charAt(0)) + "佰";
            if (str.charAt(1) == '0')
                result = result + "零" + toCNword(str.charAt(2));
            else
                result = result + toCNword(str.charAt(1)) + "拾" + toCNword(str.charAt(2));
        }
        if (str.length() == 4 && str.charAt(0) != '0')// 4310 4001 4021 4102                                                // 4300
        {
            result = result + toCNword(str.charAt(0)) + "仟";
            if (str.charAt(1) == '0' && str.charAt(2) == '0' && str.charAt(3) == '0') {
                // 如果都是0 则直接是 X000
            } else if (str.charAt(1) == '0' && str.charAt(2) == '0' && str.charAt(3) != '0') {
                result = result + "零" + toCNword(str.charAt(3));// X00X
            } else if (str.charAt(1) != '0' && str.charAt(2) == '0' && str.charAt(3) == '0') {
                result = result + toCNword(str.charAt(1)) + "佰";// XX00
            } else if (str.charAt(1) == '0' && str.charAt(2) != '0' && str.charAt(3) == '0') {
                result = result + "零" + toCNword(str.charAt(2)) + "拾";// X0X0
            } else if (str.charAt(1) != '0' && str.charAt(2) != '0' && str.charAt(3) == '0') {
                result = result + toCNword(str.charAt(1)) + "佰" + toCNword(str.charAt(2)) + "拾";// XXX0
            } else if (str.charAt(1) != '0' && str.charAt(2) == '0' && str.charAt(3) != '0') {
                result = result + toCNword(str.charAt(1)) + "佰" + "零" + toCNword(str.charAt(3));// XX0X
            } else if (str.charAt(1) != '0' && str.charAt(2) == '0' && str.charAt(3) != '0') {
                result = result + toCNword(str.charAt(1)) + "佰" + toCNword(str.charAt(2)) + "拾";// XXX0
            } else {
                result = result + toCNword(str.charAt(1)) + "佰" + toCNword(str.charAt(2)) + "拾"
                        + toCNword(str.charAt(3));// XXXX
            }
        } else if (str.length() == 4&&str.charAt(0) == '0') {
            if (str.charAt(1) == '0' && str.charAt(2) == '0' && str.charAt(3) == '0') {
                result = result + "零";// 如果都是0 则直接是 0000
            } else if (str.charAt(1) == '0' && str.charAt(2) == '0' && str.charAt(3) != '0') {
                result = result + "零" + toCNword(str.charAt(3));// 000X
            } else if (str.charAt(1) != '0' && str.charAt(2) == '0' && str.charAt(3) == '0') {
                result = result + toCNword(str.charAt(1)) + "佰";// 0X00
            } else if (str.charAt(1) == '0' && str.charAt(2) != '0' && str.charAt(3) == '0') {
                result = result + "零" + toCNword(str.charAt(2)) + "拾";// 00X0
            } else if (str.charAt(1) != '0' && str.charAt(2) != '0' && str.charAt(3) == '0') {
                result = result + "零" + toCNword(str.charAt(1)) + "佰" + toCNword(str.charAt(2)) + "拾";// 0XX0
            } else if (str.charAt(1) != '0' && str.charAt(2) == '0' && str.charAt(3) != '0') {
                result = result + "零" + toCNword(str.charAt(1)) + "佰" + "零" + toCNword(str.charAt(3));// 0X0X
            } else if (str.charAt(1) != '0' && str.charAt(2) == '0' && str.charAt(3) != '0') {
                result = result + "零" + toCNword(str.charAt(1)) + "佰" + toCNword(str.charAt(2)) + "拾";// 0XX0
            } else {
                result = result + "零" + toCNword(str.charAt(1)) + "佰" + toCNword(str.charAt(2)) + "拾"
                        + toCNword(str.charAt(3));// 0XXX
            }
        }
        return result;
    }

    private static String toCNword(char charAt) {
        String result = "";
        if (charAt == '1')
            result = "壹";
        else if (charAt == '2')
            result = "贰";
        else if (charAt == '3')
            result = "叁";
        else if (charAt == '4')
            result = "肆";
        else if (charAt == '5')
            result = "伍";
        else if (charAt == '6')
            result = "陆";
        else if (charAt == '7')
            result = "柒";
        else if (charAt == '8')
            result = "捌";
        else if (charAt == '9')
            result = "玖";
        else if (charAt == '0')
            result = "零";
        return result;
    }
}
