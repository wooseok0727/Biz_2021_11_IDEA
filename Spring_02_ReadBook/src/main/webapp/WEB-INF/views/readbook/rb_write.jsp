<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <form class="readBook_write" method="post">
        <fieldset>
            <legend>WRITE</legend>
            <div class="input">
                <input name="isbn" placeholder="ISBN"/>
                <input name="title" placeholder="BOOK TITLE"/>
            </div>
            <div class="input">
                <label>DATE</label><input name="sDate" type="date"/>
                <label>START</label><input name="sTime" type="time"/>
                <label>END</label><input name="eTime" type="time"/>
            </div>
            <div class="input" >
                <input name="subject" placeholder="A book that is shut is but a block.."/>
            </div>
            <div class="input" >
                <input name="content" placeholder="Please enter your content"/>
            </div>
            <div class="input btn_box right">
                <button type="submit" class="save">SAVE</button>
                <button type="reset" class="reset">RESET</button>
                <button type="button" class="list">LIST</button>
            </div>
        </fieldset>
    </form>
