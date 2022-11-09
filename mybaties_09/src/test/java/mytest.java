import dao.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.IDutils;
import utils.mybatiesUtile;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class mytest {
    @Test
    public void test(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.close();
    }
    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "Java2");
//        map.put("author", "狂神说2");
        map.put("id", "bcd430d6859b4eb7a6bef7d8a86a3d87");
        mapper.updateBlog(map);


        sqlSession.close();
    }
}
