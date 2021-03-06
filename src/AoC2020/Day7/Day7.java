package AoC2020.Day7;

import utils.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7 {

    private static Map<String, List<BagInfo>> bags = new HashMap<>();
    private static final List<String> input = FileUtil.readFileString("src/AoC2020/Day7/day7.txt");

    public static void main(String[] args) {
            part1And2();
    }

    public static void part1And2() {
        for (String s : input) {
            String[] split1 = s.substring(0, s.length() - 1).split("bags contain");
            String outerBag = split1[0].trim();
            String[] innerbags = split1[1].split(",");
            List<BagInfo> bagInfos = new ArrayList<>();
            for (String innerbag : innerbags) {
                innerbag = innerbag.replace("bags", "").replace("bag", "").trim();
                int index = innerbag.trim().indexOf(" ");
                String quantityStr = innerbag.substring(0, index);
                if (!quantityStr.equalsIgnoreCase("no")) {
                    BagInfo bagInfo = new BagInfo();
                    bagInfo.quantity = Integer.parseInt(quantityStr);
                    bagInfo.bagName = innerbag.substring(index + 1);
                    bagInfos.add(bagInfo);
                }
            }

            bags.put(outerBag, bagInfos);
        }

        int count = 0;
        for (String bag : bags.keySet()) {
            if (isGoldBagInBag(bag)) {
                count++;
            }
        }
        System.out.println("Part 1: " + count);
        System.out.println("Part 2: " + (countBagsInGoldBag("shiny gold") - 1));

    }

    private static boolean isGoldBagInBag(String bag) {
        for (BagInfo subBag : bags.get(bag)) {
            if (subBag.bagName.equalsIgnoreCase("shiny gold")) {
                return true;
            }
        }

        for (BagInfo subBag : bags.get(bag)) {
            if (isGoldBagInBag(subBag.bagName)) {
                return true;
            }
        }
        return false;
    }

    private static int countBagsInGoldBag(String bag) {
        List<BagInfo> bagList = bags.get(bag);
        int count = 1;
        for (BagInfo bagInfo : bagList) {
            count += (bagInfo.quantity * countBagsInGoldBag(bagInfo.bagName));
        }
        return count;
    }

    public static class BagInfo {
        public int quantity;
        public String bagName;
    }
}

