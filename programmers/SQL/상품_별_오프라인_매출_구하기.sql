SELECT PRODUCT_CODE, SUM(SALES_AMOUNT)*PRICE AS SALES
FROM PRODUCT LEFT OUTER JOIN OFFLINE_SALE ON PRODUCT.PRODUCT_ID = OFFLINE_SALE.PRODUCT_ID
WHERE OFFLINE_SALE.PRODUCT_ID IS NOT NULL
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE