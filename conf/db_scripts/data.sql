INSERT INTO public.products(
	item_price, product_name)
	VALUES (100.00, 'Estructura de cama'),
	(200.00, 'Armario'),
	(150.00, 'Colchón'),
	(60.00, 'Alfombra'),
	(1.00, 'Percha');

INSERT INTO public.invoice(
	invoice_date, total_price)
	VALUES ('19/09/2019', 150);

INSERT INTO public.product_invoice(
                         amount, invoice_id, product_id)
                         VALUES (1, 1, 3);