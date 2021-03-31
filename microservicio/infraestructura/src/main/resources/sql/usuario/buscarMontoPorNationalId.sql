declare idUsuario int;
begin
select :idUsuario = idUsuario from usuarios where cedula = :cedula;
select * from alquiler where idUsuario = :idUsuario and estado = 1 ;
end