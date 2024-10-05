package com.example.practice.OnlineTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


public class BrickSmash {

    /*I want you to search an IBM coding assesment question solution.
    The question : There are n bricks arranged in a row at position numbered
    from 1 through n, inclusive. There is an array, newstons[n],
    that contains an integer idicating thr number of newtons required to smash
    a brick There are two hammers, one big and one small. The big hammer can
    smash any brick with one blow. The small hammer reduces the newtons required
    by 1 for each blow to a brick. For example, a brick requires 3 newtons of force.
    It will take 1 blow with the big hammer, or 3 blows with the small hammer to smash it.
    There is a limit to how many times the big hammer can be used.
    Determine 3 values:
    1. The minimum number of blows to smash all the bricks
    2. The 1- based indices of the bricks smashed by the big hammer sorted ascending
    3. The 1- based indices of the bricks smashed by the small hammer sorted ascending
    Return the values as a 2- dimensional array, [[total hits], [big hammer hits], [small hammer hits]].

     * */
    /*
     * Complete the 'smashTheBricks' function below.
     *
     * The function is expected to return a 2D_LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER bigHits
     *  2. INTEGER_ARRAY newtons
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 9, 3, 2, 5, 8, 4, 6);
//        smashTheBricks(9, list);
        smashTheBricks(4, Arrays.asList(3, 2, 5, 4, 6, 7, 9));
//        smashTheBricks(0, Arrays.asList(2));
//        smashTheBricks(0, Arrays.asList(3, 10000000, 100000000, 1000000000));
//        smashTheBricks1(2, Arrays.asList(3, 4, 1, 5));
        System.out.println();
//        smashTheBricks(2, Arrays.asList(3, 4, 1, 5));


//        smashTheBricks(119, Arrays.asList(533159778, 907179054, 896985999, 450378127, 157084314, 322312706,
//                841944870, 295470934, 353695808, 786973781, 588805513, 584231707, 485056476, 632216487, 591175632,
//                335409286, 214236767, 380193658, 17959864, 618521864, 159160176, 24180612, 595974560, 200640132,
//                243550258, 142769223, 38336790, 428888715, 288528420, 30296525, 474717963, 63437145, 740331130,
//                861688726, 124884332, 755475704, 345473629, 77531223, 788599561, 802009030, 512025208, 820702904,
//                566670710, 922199446, 820536865, 207974352, 517554586, 748934077, 697566413, 191429279, 764664050,
//                422122639, 315204256, 645359743, 294669494, 183396732, 893451540, 244909643, 737677027, 804404171,
//                607565496, 883156833, 142357111, 906748272, 456080205, 961894738, 13979473, 200507463, 510658815,
//                663032034, 586748483, 857591757, 332521005, 864227646, 38032028, 613491158, 135841823, 421116162,
//                232599664, 188010724, 185436604, 104400153, 862569596, 133091759, 859090975, 579548382, 378770273,
//                692768510, 161308410, 350870400, 528088714, 206335679, 996637440, 589226580, 877314430, 921682031,
//                371791644, 564601469, 839194213, 217119015, 504601615, 184298131, 368166015, 645862560, 179796375,
//                393451964, 390111910, 307041954, 598890980, 276278617, 191215589, 265151115, 586569579, 881095438,
//                428317547, 128545551, 430542757, 185574779, 175222695, 490377746, 507501612, 230387033, 655798760,
//                764651497, 462000868, 656320772, 366215936, 682073029, 517894403, 777395900, 623211006, 506845530,
//                974521770, 778792799, 823630767, 90796723, 808848042, 85266563, 555322200, 943400160, 639272963,
//                813759795, 733764905, 55162691, 447899726, 674693266, 792686642, 505305439, 150270345, 831151921,
//                165853967, 262992877, 246193438, 227695818, 899688529, 90802494, 836439029, 112481597, 993472501,
//                221078835, 568405287, 496442097, 47226199, 450871026, 227017380, 877599619, 231053236, 348543139,
//                960886086, 375971770, 608554347, 262027259, 98204557, 302816855, 22355462, 49725173, 103074353,
//                965849726, 341688841, 112010147, 142600226, 492539010, 220148917, 66853147, 967638184, 988836177,
//                409211268, 879146263, 380743022, 113472720, 738764083, 568064315, 599539355, 751663522, 238992367,
//                365265434, 889738081, 886819380, 560060456, 837831221, 471950482, 195450386, 875538929, 21333381,
//                482880107, 79983722, 733270175, 31674899, 521856889, 303094514, 169035503, 401203209, 622232432
//        ));
    }

    public static List<List<Long>> smashTheBricks(int bigHits, List<Integer> newtons) {
        // Write your code here
        List<List<Long>> resList = new ArrayList<>();
        newtons = newtons.stream().filter(e-> Objects.nonNull(e)).collect(Collectors.toList());
        List<Integer> copyList = new ArrayList<>(newtons);
        Collections.sort(copyList);
        Collections.reverse(copyList);
//        System.out.println(bigHits);
//        System.out.println(newtons);
        Long total = 0L;
        Long big = 0L;
        List<Integer> bigHammerList = new ArrayList<>();
        List<Long> bigHammerPositionList = new ArrayList<>();
        List<Integer> smallHammerList = new ArrayList<>();
        List<Long> smallHammerPositionList = new ArrayList<>();

        if (bigHits >= newtons.size()) {
            big = (long) newtons.size();
            resList.add(List.of(big));

            LongStream longStream = LongStream.range(1, bigHits);
            bigHammerPositionList.addAll(longStream.boxed().collect(Collectors.toList()));
            resList.add(bigHammerPositionList);
            smallHammerPositionList.add(-1L);
            resList.add(smallHammerPositionList);
            return resList;
            //    System.out.println(newtons.size());
        }

        int i = 0;
        if (bigHits > 0) {
            for (i = 0; i < bigHits; i++) {
                bigHammerList.add(copyList.get(i));
            }
            for (int e : bigHammerList) {
                bigHammerPositionList.add((long) newtons.indexOf(e) + 1);
            }

        } else {
            bigHammerPositionList.add(-1L);
        }

        for (; i < copyList.size(); i++) {
            smallHammerList.add(copyList.get(i));
        }

        Integer smallCount = 0;
        for (Integer a : smallHammerList) {
            smallCount += a;
        }
        total = (long) bigHits + smallCount;

        for (int e : smallHammerList) {
            smallHammerPositionList.add((long) newtons.indexOf(e) + 1);
        }

        Collections.sort(bigHammerPositionList);
        Collections.sort(smallHammerPositionList);

        resList.add(Arrays.asList(total));
        resList.add(bigHammerPositionList);
        resList.add(smallHammerPositionList);
        System.out.println(resList);
        return resList;
    }


}
