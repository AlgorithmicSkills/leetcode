package com.antonromanov.algorithms.linkedlist.merged;

import com.antonromanov.algorithms.linkedlist.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        // создаем пустую мини-кучу, используя объект сравнения для упорядочивания минимальной кучи
        PriorityQueue<ListNode> pq;
        pq = new PriorityQueue<ListNode>(Comparator.comparingInt(a -> ((ListNode) a).val));

        // помещаем первый узел каждого списка в минимальную кучу
        pq.addAll(Arrays.asList(lists).subList(0, lists.length));

        // взять два указателя, голову и хвост, где голова указывает на первый узел
        // выходного списка, а хвост указывает на его последний узел
        ListNode head = null, last = null;

        // работать до тех пор, пока мини-куча не станет пустой
        while (!pq.isEmpty()) {
            // извлечь минимальный узел из минимальной кучи
            ListNode min = pq.poll();

            // добавляем минимальный узел в выходной список
            if (head == null) {
                head = last = min;
            } else {
                last.next = min;
                last = min;
            }

            // берем следующий узел из "того же" списка и вставляем его в min-heap
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        // возвращаем головной узел объединенного списка
        return head;
    }

    public static ListNode[] prepareTestData() {
        int k = 3;    // общее количество связанных списков

        // массив для хранения головных узлов связанных списков
        ListNode[] lists = new ListNode[k];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(5);
        lists[0].next.next = new ListNode(7);

        lists[1] = new ListNode(2);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(6);
        lists[1].next.next.next = new ListNode(9);

        lists[2] = new ListNode(4);
        lists[2].next = new ListNode(8);
        lists[2].next.next = new ListNode(10);

        return lists;
    }
}
