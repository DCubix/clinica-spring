alter table medico add column ativo tinyint;
update medico set ativo=1;