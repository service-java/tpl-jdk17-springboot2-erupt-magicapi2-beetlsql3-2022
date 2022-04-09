cols
===
```sql
id,name,age,create_time,update_time
```

condition
===
```sql
1 = 1
-- @if(!isEmpty(id)){
and id=#{id}
-- @}
-- @if(!isEmpty(name)){
and name=#{name}
-- @}
-- @if(!isEmpty(age)){
and age=#{age}
-- @}
-- @if(!isEmpty(createTime)){
and create_time=#{createTime}
-- @}
-- @if(!isEmpty(updateTime)){
and update_time=#{updateTime}
-- @}
```

selectUser
===
```sql
-- 注释
select #{use("cols")}
from user
where  #{use("condition")}
```


jsonMap
===
```json
{
"id":"id",
"name":"name",
"age":"age",
"createTime":"create_time",
"updateTime":"update_time"
}
```