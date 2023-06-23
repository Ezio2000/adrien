package org.adrien.sdk.base.pojo.struc.book;

import java.util.List;

/**
 * @author Xieningjun
 * @date 2023/6/2 18:06
 * @description 书本数据结构
 */
public interface Book<H, B, T> {

    Integer size();

    Integer page();

    Integer cursor();

    default void cursor(Integer cursor) {
        if (this.ltCursor(cursor)) {
            this.setCursor(0);
        } else if (this.gtCursor(cursor)) {
            this.setCursor(this.page() - 1);
        } else {
            this.setCursor(cursor);
        }
    }

    default H head() {
        return null;
    }

    List<IPage<B>> body();

    default T tail() {
        return null;
    }

    void setCursor(Integer cursor);

    default Boolean ltCursor(Integer cursor) {
        return cursor < 0;
    }

    default Boolean gtCursor(Integer cursor) {
        return cursor > this.page();
    }

    default Boolean validCursor(Integer cursor) {
        return 0 <= cursor && cursor <= this.page();
    };

}
