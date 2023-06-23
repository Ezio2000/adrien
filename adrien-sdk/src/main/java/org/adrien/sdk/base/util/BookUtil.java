package org.adrien.sdk.base.util;

import org.adrien.sdk.base.pojo.struc.book.Book;
import org.adrien.sdk.base.pojo.struc.book.IPage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/2 18:54
 * @description 书本工具
 */
public class BookUtil {

    public static <B> IPage<B> nextPage(Book<?, B, ?> book, Boolean mark) {
        return toPage(book, book.cursor() + 1, mark);
    }

    public static <B> IPage<B> toPage(Book<?, B, ?> book, Integer page, Boolean mark) {
        IPage<B> iPage;
        if (book.ltCursor(page)) {
            iPage = book.body().get(0);
        } else if (book.gtCursor(page)) {
            iPage = book.body().get(book.page() - 1);
        } else {
            iPage = book.body().get(page);
        }
        if (mark) {
            book.cursor(page);
        }
        return iPage;
    }

    public static <B> B read(Book<?, B, ?> book, Integer page, Boolean mark) {
        IPage<B> iPage = toPage(book, page, mark);
        return read(iPage);
    }

    public static <B> B read(Book<?, B, ?> book) {
        IPage<B> iPage = toPage(book, book.cursor(), true);
        return read(iPage);
    }

    public static <B> B read(IPage<B> iPage) {
        return iPage.getContent();
    }

    public static <B> List<IPage<List<B>>> pagin(List<B> bList, Integer page, Integer pageSize) {
        List<IPage<List<B>>> paginResult = new ArrayList<>();
        float size = bList.size();
        for (int i = 0; i < page; i++) {
            List<B> pageBList = new ArrayList<>();
            for (int j = (i * pageSize); j < (i + 1) * pageSize; j++) {
                try {
                    pageBList.add(bList.get(j));
                } catch (Exception ignored) {}
            }
            paginResult.add(
                    IPage.<List<B>>builder()
                            .page(i)
                            .content(pageBList)
                            .build()
            );
        }
        return paginResult;
    }

    public static <B> List<IPage<List<B>>> autoPagin(List<B> bList, Integer page) {
        List<IPage<List<B>>> paginResult = new ArrayList<>();
        float size = bList.size();
        double pageSize = Math.ceil(size / page);
        for (int i = 0; i < page; i++) {
            List<B> pageBList = new ArrayList<>();
            for (int j = (int) (i * pageSize); j < (i + 1) * pageSize; j++) {
                try {
                    pageBList.add(bList.get(j));
                } catch (Exception ignored) {}
            }
            paginResult.add(
                    IPage.<List<B>>builder()
                            .page(i)
                            .content(pageBList)
                            .build()
            );
        }
        return paginResult;
    }

}
