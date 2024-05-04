INSERT INTO TB_APLICATIVO (id_aplicativo, nome, valor)
VALUES
    ('e2a3017a-9fb8-4cc3-9101-5d5fe7f7ab01', 'Instagram', 10.50),
    ('d5d7b8f0-08f2-4fe1-bb6d-0d2c1a74b3b4', 'Twitter', 20.75),
    ('26d9bc92-f837-4df9-8b8d-14840c4ad2c3', 'Whats', 15.00),
    ('d28d67a2-35fc-43a6-8f91-904d9fd6992a', 'TikTok', 12.25),
    ('c4c9a5b1-ff77-4eaf-96b5-bf59d628d8de', 'Email', 8.99);

INSERT INTO TB_CLIENTE (id_cliente, nome, email)
VALUES
    ('e29b0c12-5891-40b0-b9e5-57de5f68e6c6', 'Guilherme', 'cliente1@example.com'),
    ('41ae93bc-5a3d-44b8-85b4-3b11d22fd78a', 'Diego', 'cliente2@example.com'),
    ('5a805fc9-b74c-44d4-917f-69b10a7e8b9c', 'Joao', 'cliente3@example.com'),
    ('d0809b7d-f83b-493f-85f7-8363d02a5e29', 'Rodrigo', 'cliente4@example.com'),
    ('9e9974fb-89a1-40e4-a670-4b37b7b6ff64', 'Messi', 'cliente5@example.com'),
    ('126d2b6a-26d9-4c33-8672-734ad48286dc', 'Cristiano Ronaldo', 'cliente6@example.com'),
    ('3bdc8a17-282a-4717-99a2-d3cf5b8f7c74', 'Enner Valencia', 'cliente7@example.com'),
    ('d3c90a88-1402-4b8d-84d6-6e7e30f45bf1', 'Rafael Santos', 'cliente8@example.com'),
    ('89038205-8d50-4fc7-a3e6-8e0e9f151593', 'Rafael Sobis', 'cliente9@example.com'),
    ('9c1d6eb2-083e-4f9e-aa5d-ec728c54c26c', 'Dalessandro', 'cliente10@example.com');


INSERT INTO TB_ASSINATURA (id_assinatura, id_cliente, id_aplicativo, inicio_vigencia, fim_vigencia, status)
VALUES
    ('1c13a0c8-fa36-4951-b16b-5f34f9fd4071', 'e29b0c12-5891-40b0-b9e5-57de5f68e6c6', 'e2a3017a-9fb8-4cc3-9101-5d5fe7f7ab01', '2024-04-01', '2024-05-01','ATIVA'),
    ('f4a20568-9441-4ee8-95c2-3fd0541f14f7', '41ae93bc-5a3d-44b8-85b4-3b11d22fd78a', 'd5d7b8f0-08f2-4fe1-bb6d-0d2c1a74b3b4', '2024-04-02', '2024-05-02','CANCELADA' ),
    ('77b7fcda-2f3a-4141-9b5c-20eaa42b11b8', '5a805fc9-b74c-44d4-917f-69b10a7e8b9c', '26d9bc92-f837-4df9-8b8d-14840c4ad2c3', '2024-04-03', '2024-05-03','ATIVA'),
    ('86c04a70-185a-4f80-bc65-08b15614a8c2', 'd0809b7d-f83b-493f-85f7-8363d02a5e29', 'd28d67a2-35fc-43a6-8f91-904d9fd6992a', '2024-04-04', '2024-05-04','CANCELADA'),
    ('4540c5a9-545a-4ad5-8445-97a1c7c22447', '9e9974fb-89a1-40e4-a670-4b37b7b6ff64', 'c4c9a5b1-ff77-4eaf-96b5-bf59d628d8de', '2024-04-05', '2024-05-05','ATIVA');

INSERT INTO TB_USUARIO (idusuario, senha)
VALUES ('admin','admin')


