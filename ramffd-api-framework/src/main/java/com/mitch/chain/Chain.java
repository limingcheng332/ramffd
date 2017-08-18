package com.mitch.chain;

import com.mitch.netty.massage.Response;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface Chain {
    <T> T handle() throws NoSuchMethodException;
}
